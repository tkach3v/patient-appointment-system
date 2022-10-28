# Patient Appointment System (SOAP, REST, Spring Boot)

Built RESTful API for an appointment system using Spring Boot, PostgreSQL, Spring Data, JPA, Rest API, SOAP, MapStruct, Luquibase, Swagger, Spring Validation.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/tkach3v/patient-appointment-system.git
```

**2. Create PostgreSQL database**
```bash
create database appointment_system

```

**3. Change PostgreSQL username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your postgresql installation

**4. Run the app using Maven**

```bash
mvn spring-boot:run
```

- The app will start running at <http://localhost:8080>
- Swagger UI available at <http://localhost:8080/api/v1/swagger-ui/index.html>
- Also use postman collection at <https://www.getpostman.com/collections/99c35887f4eec5a9b2d2>
