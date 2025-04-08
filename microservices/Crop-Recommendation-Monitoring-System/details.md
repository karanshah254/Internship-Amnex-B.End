# 🌾 Project Name: Crop Recommendation & Monitoring System
### Goal 
- >Recommend suitable crops to farmers based on input like soil type, location, and season, using microservice architecture. Data will be fed using Postman.

### Microservices involved
1. Farmer Service:- 
- >Get farmer info, store data like name, location, soil type and season.
2. Crop Suggestion Service:- 
- >Get farmer data, Recommend crops based on condition.
3. Crop Monitoring Service:-
- >Helps farmers track the health and growth status of the crops they planted based on recommendations.

### TECH STACK:
1. Framework: Spring Boot
2. Database: H2 database
3. Build tool: Maven
4. API testing: POSTMAN

### Swagger Implementation of all services
1. For farmer service: <link>http://localhost:8081/swagger-ui</link>
1. For crop suggestion service: <link>http://localhost:8082/swagger-ui</link>
1. For crop monitoring service: <link>http://localhost:8083/swagger-ui</link>


### How it works?
- >All the services mentioned here have their own port nummber and endpoints to access these url
- >We have used API-GATEWAY(a single entry point for client request), it routes them to appropriate backend services and handling tests.
- >Here instead of using port number 8081/82/83 we have use <link>http://localhost:8080/{endpoint}</link>