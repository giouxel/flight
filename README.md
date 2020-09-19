# Flight
A REST API listing flight info, developed using Spring Boot
### System Dependencies
- Java 8
- Web Server like Apache Tomcat
> WAR file that will be deployed to server can be created from command line by using jar tool of JDK. Use `jar -cvf projectname.war *` inside the project directory
- Database 
> Hibernate is used. So many database can be used but Datasource must be changed accordingly. The one used here is for MySQL
### Third Party
Swagger
### Application Up and Running
Access the application from `http://localhost:8080`

No authentication needed

The endpoint to make the api call is `http://localhost:8080/api/flight`. An optional parameter `airport` can be supplied to get the list of flights that take off from that
specific airport

Sample response:
```
[
  ...
  {
      "origin": "HER",
      "destination": "SKG",
      "departure": "2020-05-13T22:00:00+03:00",
      "arrival": "2020-05-13T23:00:00+03:00",
      "aircraft": "747-400"
  },
  {
      "origin": "RHO",
      "destination": "SKG",
      "departure": "2020-05-13T10:00:00+03:00",
      "arrival": "2020-05-13T11:05:00+03:00",
      "aircraft": "A320"
  }
  ...
]
```
### Test
API is tested using JUnit and RestTemplate
### Documentation
Documentation is made using Swagger

Access the documentation from `localhost:8080/swagger-ui.html`
