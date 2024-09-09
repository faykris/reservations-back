# Spring Boot: Reservation Project - REST API

This project demonstrates how to make reservation in a hotel managed in a Spring Boot application.

## Overview

This project shows the implementation of the information flow at each step of the reservation.

Technologies used:
- Spring Boot 3
- Spring Security 6
- jsonwebtoken

## Installation

Follow these steps to install and run the project:

1. Create a database named `reservations` in PostgreSQL
2. Clone the repository: `git clone https://github.com/faykris/reservations-back.git`
3. Navigate to the project directory: `cd your-repo`
4. Change your respective DB credentials in `application.properties` file
4. Build the project using Maven:: `mvn clean install`
5. Run the project: `mvn spring-boot:run`
6. Test the API Rest using Postman or another application at `http://localhost:8080`.