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
6. Perform the database inserts specified below these instructions
7. Test the API Rest using Postman or another application at `http://localhost:8080`

### Run insertions

```SQL
INSERT INTO room (name, description, price, max_guests, url_image)
VALUES
   ('Deluxe King Room', 'A spacious room with a king-size bed, luxurious linens, and a city view.', 300.00, 2, 'https://github.com/user-attachments/assets/e1c083d1-3441-45b2-a9a1-3227380704fe'),
   ('Executive Suite', 'An elegant suite with a separate living area, perfect for business travelers.', 500.00, 4, 'https://github.com/user-attachments/assets/0ff3b3bf-618d-40b0-86cc-5ab9607de889'),
   ('Presidential Suite', 'The most luxurious suite in the hotel, with panoramic views and VIP amenities.', 1200.00, 6, 'https://github.com/user-attachments/assets/ccfe37c9-b2e6-4be9-b234-c563e38745d5'),
   ('Ocean View Room', 'A beautiful room with a balcony offering breathtaking ocean views.', 350.00, 2, 'https://github.com/user-attachments/assets/11ea9501-8c9e-4c69-8700-fede093a4cc4'),
   ('Garden View Suite', 'A peaceful suite with a private garden terrace and modern amenities.', 450.00, 3, 'https://github.com/user-attachments/assets/9bfe0a8b-1ce5-461b-baa0-74211d3a02bb'),
   ('Penthouse Suite', 'A luxurious penthouse with private access and a rooftop terrace.', 1500.00, 5, 'https://github.com/user-attachments/assets/8b27a72a-0d34-4c83-b542-5f0884bbac7b'),
   ('Junior Suite', 'A comfortable suite with a seating area and garden views.', 400.00, 3, 'https://github.com/user-attachments/assets/3cb035b5-223a-48d7-a8fd-d715c892579b'),
   ('Luxury Twin Room', 'A twin room with two plush beds and stylish decor.', 250.00, 2, 'https://github.com/user-attachments/assets/153dc16c-3e95-44e1-b97f-c66ea0f114cc'),
   ('Honeymoon Suite', 'A romantic suite with a private jacuzzi and stunning views.', 700.00, 2, 'https://github.com/user-attachments/assets/d6e292fd-8de4-4794-a3ba-cdbfc6a740c4'),
   ('Family Room', 'A spacious room designed for families, with extra beds and child-friendly amenities.', 550.00, 4, 'https://github.com/user-attachments/assets/9967cd9f-0d0d-40ed-8a0d-7536ed4d0b47');

INSERT INTO users (username, password, firstname, lastname)
VALUES
   ('john_doe', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'John', 'Doe'),
   ('jane_smith', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Jane', 'Smith'),
   ('michael_brown', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Michael', 'Brown'),
   ('emily_jones', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Emily', 'Jones'),
   ('william_taylor', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'William', 'Taylor'),
   ('olivia_johnson', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Olivia', 'Johnson'),
   ('james_williams', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'James', 'Williams'),
   ('sophia_davis', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Sophia', 'Davis'),
   ('charles_miller', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Charles', 'Miller'),
   ('isabella_anderson', '$2a$10$eh6w0yznfQRHrVYRB9OUy.bAqjpAhxLA/QJtIuZlFBI.YFhDyFoc2', 'Isabella', 'Anderson');

INSERT INTO roles (name)
VALUES
   ('ADMIN'),
   ('CUSTOMER');

INSERT INTO user_roles (user_id, role_id)
VALUES
   (1, 1),
   (2, 2),
   (3, 2),
   (4, 2),
   (5, 2),
   (6, 2),
   (7, 2),
   (8, 2),
   (9, 2),
   (10, 2);

INSERT INTO reservation (user_id, room_id, check_in, check_out, created_at, status, total_price)
VALUES
   (1, 1, '2024-09-10 15:00:00', '2024-09-15 11:00:00', '2024-09-01 10:30:00', 'CONFIRMED', 1250),
   (2, 2, '2024-09-12 15:00:00', '2024-09-17 11:00:00', '2024-09-02 11:00:00', 'PENDING', 1750),
   (3, 3, '2024-09-14 15:00:00', '2024-09-18 11:00:00', '2024-09-03 12:00:00', 'CANCELLED', 1250),
   (4, 4, '2024-09-16 15:00:00', '2024-09-19 11:00:00', '2024-09-04 13:00:00', 'CONFIRMED', 1850),
   (5, 5, '2024-09-18 15:00:00', '2024-09-22 11:00:00', '2024-09-05 14:00:00', 'PENDING', 1950);
```