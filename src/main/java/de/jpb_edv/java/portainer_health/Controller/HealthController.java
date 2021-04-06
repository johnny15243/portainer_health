package de.jpb_edv.java.portainer_health.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import de.jpb_edv.java.portainer_health.Model.ContainerModel;
import de.jpb_edv.java.portainer_health.Model.CredentialModel;
import de.jpb_edv.java.portainer_health.Model.TokenModel;
import reactor.core.publisher.Mono;

@RestController
public class HealthController {

    @Value("${ph.password}")
    protected String password;
    @Value("${ph.username}")
    protected String username;
    @Value("${ph.host}")
    protected String portainer_server;
    @Value("${ph.port}")
    protected String portainer_port;
    
    @Autowired
    WebClient wc;

    @Bean
    WebClient getWebClient() {
        return WebClient.create("http://"+portainer_server+":"+portainer_port);
    }

    @GetMapping({ "", "/", "/home","/health" })
    public List<ContainerModel> getHealthStatus(){

        String jwtToken = getAuthToken();

        return getContainerData(jwtToken);
    }

    private List<ContainerModel> getContainerData(String token){
        System.out.println(token);
        List<ContainerModel> result = wc.get()
                                        .uri("/api/endpoints/1/docker/containers/json?all=1")
                                        .headers(h-> h.setBearerAuth(token))
                                        .retrieve()
                                        .bodyToFlux(ContainerModel.class)
                                        .collectList()
                                        .block();
        return result;
    }

    private String getAuthToken(){
        CredentialModel loginCredentials = new CredentialModel(username,password);
        System.out.println(loginCredentials);
        TokenModel result = wc.post()
                                .uri("/api/auth")
                                .body(Mono.just(loginCredentials), CredentialModel.class)
                                .accept(MediaType.APPLICATION_JSON)
                                .retrieve()
                                .bodyToMono(TokenModel.class)
                                .block();
        return result.getJwt();
    }
}
