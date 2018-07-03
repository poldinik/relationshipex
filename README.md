
## Running Application

1) mvn clean install
2) mvn wildfly:start
3) mvn wildfly:deploy

## TO-FIX

Una volta creato un User e un Gruppo, ed aver inserito User nel Gruppo, l'API Get per ottenere la lista degli utenti e lista dei gruppi a cui appartengono non funziona con errore:
"org.jboss.resteasy.spi.UnhandledException: com.fasterxml.jackson.databind.JsonMappingException: failed to lazily initialize a collection of role: com.cosmink.models.UserGroup.UserGroup.users, could not initialize proxy - no Session (through reference chain: java.util.ArrayList[0]-"



## API creazione User

http://localhost:8080/restful/api/register  (POST)

### Parametri

Content-Type: application/json

Payload: {
         	"password":"test",
         	"email": "test@gmail.com"
         }
         
## API get Users

http://localhost:8080/restful/api/users  (GET)


## API creazione UserGroup

http://localhost:8080/restful/api/groups (POST)

### Parametri

Content-Type: application/json

Payload: {
         	"name": "gruppo1",
         	"description":"nuovo gruppo test"
         }


## API creazione Membership

http://localhost:8080/restful/api/memberships (POST)

permette di inserire un User in un Gruppo

### Parametri

Content-Type: application/json

Payload: {
         	"groupId": 2,
         	"userId": 1
         }