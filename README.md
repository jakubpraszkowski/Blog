# Blog Application

## 1. Application Summary

Blog Application is a web application built with Spring Boot that allows users to create, edit, and delete blog posts. The application uses JWT for user authorization and MySQL as the database.

## 2. Setup/Installation

### Prerequisites

- Java 17
- Docker engine
- Maven

### Steps

1. **Clone the repository:**

   ```sh
   git clone https://github.com/jakubpraszkowski/Blog.git
   cd Blog
   ```

2. **Build the project:**
    
    ```sh
    ./mvnm clean package -DskipTests
    ```
3. **Create `.env` file:**
    Create a `.env` file in the root directory with the following content:

    ```env
    # Database Configuration
    MYSQL_ROOT_PASSWORD=root_password
    MYSQL_USER=mysql_user
    MYSQL_PASSWORD=user_password
    MYSQL_DATABASE=mysqldb_prod

    # Spring Boot Configuration
    SPRING_DATASOURCE_URL=jdbc:mysql://mysqldb:3306/mysqldb_prod?useSSL=false&allowPublicKeyRetrieval=true
    SPRING_DATASOURCE_USERNAME=root
    SPRING_DATASOURCE_PASSWORD=root_password
    ```

    Alternatively, you can use the existing `example.env` file by renaming it:

    ```sh
    mv example.env .env
    ``` 

4. **Start the application using Docker Compose:**
    ```sh
    docker compose up
    ```

## 3. How to run tests
    ```sh
    ./mvnm test
    ```

## 4. System Architecture
The application contains the following main components:

- **Controller**: Handles HTTP requests and returns responses.
- **Service**: Contains the business logic of the application.
- **Repository**: Interacts with the database.
- **Model**: Defines the database entities.
- **Security**: Configures JWT and security settings.

## 5. How to perform database migrations

To perform database migrations, use a tool like Flyway or Liquibase. In this project, you can add migration scripts to the `src/main/resources/db/migration` directory.

## 6. How to use JWT

JWT (JSON Web Token) is used for user authorization. The token is generated during login and must be included in each request as an `Authorization` header: `Bearer <token>`.

## 7. How to launch docs
After starting the application, the API documentation is available at:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)