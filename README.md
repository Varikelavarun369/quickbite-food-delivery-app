# QuickBite - Food Delivery Application

QuickBite is a full-stack food delivery web application developed using Spring Boot, MySQL, HTML, CSS, and JavaScript.  
The application allows users to browse restaurants, order food items, manage carts, and place orders through a responsive web interface.

---

## Features

- User Registration and Login
- JWT Authentication & Authorization
- Restaurant Management
- Food Item Management
- Cart Management
- Order Placement
- Order Item Management
- RESTful APIs
- Exception Handling
- Layered Architecture
- Responsive Frontend UI

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- Maven

### Frontend
- HTML
- CSS
- JavaScript

### Database
- MySQL

### Tools
- Git
- GitHub
- Postman
- IntelliJ IDEA / Eclipse

---

## Project Structure

```text
fooddelivery
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ java/com/fooddelivery
 ┃ ┃ ┃ ┣ controller
 ┃ ┃ ┃ ┣ service
 ┃ ┃ ┃ ┣ repository
 ┃ ┃ ┃ ┣ entity
 ┃ ┃ ┃ ┣ dto
 ┃ ┃ ┃ ┣ security
 ┃ ┃ ┃ ┗ exception
 ┃ ┃ ┗ resources
 ┃ ┗ test
 ┣ frontend
 ┃ ┣ css
 ┃ ┣ js
 ┃ ┣ images
 ┃ ┗ html pages
 ┣ screenshots
 ┣ pom.xml
 ┗ README.md
```

---

## API Modules

- Authentication APIs
- User APIs
- Restaurant APIs
- Food Item APIs
- Cart APIs
- Cart Item APIs
- Order APIs
- Order Item APIs

---

## Security Features

- JWT Token Authentication
- Role-Based Authorization
- Password Encryption
- Protected REST APIs

---

## Screenshots

### Home Page
![Home Page](screenshots/home.png)

### Login Page
![Login Page](screenshots/login.png)

### Restaurant Page
![Restaurant Page](screenshots/restaurant.png)

### Cart Page
![Cart Page](screenshots/cart.png)

### Order Page
![Order Page](screenshots/order.png)

---

## How to Run the Project

### Clone Repository

```bash
git clone https://github.com/Varikelavarun369/quickbite-food-delivery-app.git
```

### Configure Database

Update `application.properties` file with your MySQL credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fooddelivery
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run Backend

```bash
mvn spring-boot:run
```

### Run Frontend

Open the frontend HTML files in browser.

---

## Future Improvements

- Online Payment Integration
- Email Notifications
- Order Tracking
- Admin Dashboard
- Docker Deployment
- Cloud Deployment

---

## Author

Varikela Varun

GitHub:  
https://github.com/Varikelavarun369

---

## License

This project is developed for learning and portfolio purposes.
