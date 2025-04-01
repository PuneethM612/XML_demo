# Student Marks Management System

A Spring Boot application to manage student marks with XML-based configuration instead of annotation-based configuration.

## Features

- **Student Management**: Add, edit, view, and delete students
- **Subject Management**: Add, edit, view, and delete subjects
- **Marks Management**: Record and manage student marks for different exam types
- **Ranking System**: View top 3 students based on total marks (not average) by exam type
- **Search Functionality**: Find marks by student roll number and exam type

## Technical Details

- Spring Boot 2.3.12.RELEASE
- Java 8
- PostgreSQL database
- Hibernate ORM with XML mapping
- Thymeleaf for view templates
- Bootstrap 4.6.0 for UI

## XML-based Configuration

This application uses XML-based configuration instead of annotation-based configuration:

- XML files for bean definitions and dependency injection
- Hibernate XML mapping files for entity-database mapping
- Spring XML configuration for transaction management
- XML configuration for all services, repositories, and controllers

## Project Structure

- `src/main/java/com/example/marksmgmt/model`: Data model classes
- `src/main/java/com/example/marksmgmt/repository`: Repository interfaces and implementations
- `src/main/java/com/example/marksmgmt/service`: Service interfaces and implementations
- `src/main/java/com/example/marksmgmt/controller`: Controller classes
- `src/main/resources/META-INF`: Hibernate XML mapping files
- `src/main/resources/templates`: Thymeleaf templates
- `src/main/resources/applicationContext.xml`: Main XML configuration file

## Setup and Run

### Prerequisites

- Java 8 or higher
- PostgreSQL
- Maven

### Database Setup

1. Create a PostgreSQL database named `student_marks_mgmt`
2. Configure the database connection in `src/main/resources/application.properties`

### Running the Application

```bash
mvn spring-boot:run
```

The application will be accessible at http://localhost:8080

## Key XML Files

- `applicationContext.xml`: Main XML configuration file for Spring beans
- `Student.hbm.xml`, `Subject.hbm.xml`, `Marks.hbm.xml`: Hibernate mapping files
