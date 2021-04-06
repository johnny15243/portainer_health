# portainer_health

This is a simple **quick&dirty** SPRING **app**. 

It has only one Job. Read healthdata from Portainer and present this data.
This data could now be taken to check the health.


#### Sample docker-run function
```
docker run -name health -e SERVER_PORT=8080 -e PH_HOST=portainer.domain.com -e PH_PORT=9000 -e PH_USER=apiUser -e PH_PWD=secretpassword123 johnny15243/portainer_health:0.1-alpha
```
#### Environment-Vars Overview
ENV | Meaning
--- | --- 
**SERVER_PORT** | Sets the port for the App to run
**PH_HOST** | Portainer Host / IP
**PH_PORT** | Portainer WebUI-Port
**PH_USER** | Portainer WebUI-User with enaugh Permissions for accessing Entrypoints
**PH_PWD** | Portainer WebUI-User password


#### Sample-JSon output
```JSON
[{
  "Image":"johnny15243/portainer_health:0.1-alpha"
  ,"State":"running"
  ,"Status":"Up 7 hours"
  ,"Names":["/rpi_health"]
}]
```
