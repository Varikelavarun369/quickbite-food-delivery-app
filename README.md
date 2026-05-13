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

### User Authentication

#### Login Page
![Login Page](screenshots/login.png)

#### Register Page
![Register Page](screenshots/register.png)

---

# Admin Module

#### Admin Dashboard
![Admin Dashboard](screenshots/admin-dashboard.png)

#### Admin Dashboard - Manage Features
![Admin Dashboard 2](screenshots/admin-dashboard-2.png)

#### Add Restaurant
![Add Restaurant](screenshots/add-restaurant.png)

#### Add Food Item
![Add Food Item](screenshots/add-food-item.png)

#### Manage Orders
![Manage Orders](screenshots/manage-orders.png)

#### Manage Orders - Order Status
![Manage Orders 2](screenshots/manage-orders-2.png)

#### Manage Orders - Update Status
![Manage Orders 3](screenshots/manage-orders-3.png)

#### Manage Orders - Order Completed
![Manage Orders 4](screenshots/manage-orders-4.png)

---

# Customer Module

#### Customer Dashboard
![Customer Dashboard](screenshots/customer-dashboard.png)

#### Search Restaurant
![Search Restaurant](screenshots/search-restaurant.png)

#### View Restaurants
![View Restaurants](screenshots/view-restaurants.png)

#### Search Food Items
![Search Food Items](screenshots/search-food-items.png)

#### View Food Items
![View Food Items](screenshots/view-food-items.png)

#### Add To Cart
![Add To Cart](screenshots/add-to-cart.png)

#### Cart Page
![Cart Page](screenshots/cart-page.png)

#### Empty Cart
![Empty Cart](screenshots/empty-cart.png)

#### Orders Page
![Orders Page](screenshots/orders.png)

#### Order Details Page
![Order Details Page](screenshots/order-details.png)


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
