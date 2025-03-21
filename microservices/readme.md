### About microservices
- >It is used to create a small services for the large and complex application.
- >In this folder I have created a two services:
    1. Quiz
    2. Question
- >Application is stated such that while fteching fetching quiz with repesctive id it shows questions related to that given id.
- >Two different services have been implemented for this and used eureka client and server for merging two services and executing respective operations.
- >Question Service: It has list of questions with its question id such that id matching the quiz id goes to that list itself.
- >Quiz Service: It has list of quizes along with questions and its id.
- >Both are executing its own applications so they are called as microservices.


### API GATEWAY
- >It is pathway for client to access any of service available in server and it used single port to do this functioning.
- >In a microservices architecture, an API gateway acts as a centralized entry point for client applications, routing their requests to the appropriate backend services, and handling tasks like authentication, security, and protocol translation.