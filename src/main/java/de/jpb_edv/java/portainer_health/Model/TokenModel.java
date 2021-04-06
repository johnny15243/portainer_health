package de.jpb_edv.java.portainer_health.Model;

import java.util.Objects;

public class TokenModel {
    String jwt;

    public TokenModel() {
    }

    public TokenModel(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public TokenModel jwt(String jwt) {
        setJwt(jwt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TokenModel)) {
            return false;
        }
        TokenModel tokenModel = (TokenModel) o;
        return Objects.equals(jwt, tokenModel.jwt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jwt);
    }

    @Override
    public String toString() {
        return "{" +
            " jwt='" + getJwt() + "'" +
            "}";
    }
}
