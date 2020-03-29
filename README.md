# employee-rest

> A Spring Boot Rest API with a Vue.js client

Sample running demo at https://employee-rest.herokuapp.com/

## About

employee-rest is an example of using Spring Boot to implement a Rest API and a Vue.js client to communicate with the API.

The backend service offers the below Actions:

```
POST	/api/employees	     create new Employee
GET	/api/employees	     retrieve all Employee
GET	/api/employees/:id   retrieve a Employee by :id
PUT	/api/employees/:id   update a Employee by :id
DELETE	/api/employees/:id   delete a Employee by :id
DELETE	/api/employees	     delete all Employee
```

### Prerequisites

- Java 1.8 Developlment Kit
- Maven 3.6
- Node to recompile frontend (only needed if changes to frontend are required)

### Project setup

1. cd to `backend` folder
2. rename `/src/main/resources/application.properties.org` to `/src/main/resources/application.properties`
3. enter database configuration in `/src/main/resources/application.properties`
4. run the command `mvn spring-boot:run`
