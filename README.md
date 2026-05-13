# QuickBite - Food Delivery Application

QuickBite is a full-stack food delivery web application developed using Spring Boot, MySQL, HTML, CSS, and JavaScript.

The application allows users to browse restaurants, search food items, manage carts, place orders, and manage restaurant operations through a responsive web interface.

---

# 🚀 Features

## Authentication & Security
- User Registration and Login
- JWT Authentication & Authorization
- Role-Based Access Control
- Password Encryption
- Protected REST APIs

## Admin Features
- Restaurant Management
- Food Item Management
- Order Management
- Order Status Updates
- Admin Dashboard Management

## Customer Features
- Browse Restaurants
- Search Restaurants
- Browse Food Items
- Search Food Items
- Add to Cart
- Cart Management
- Place Orders
- View Orders
- View Order Details

## Backend Features
- RESTful API Development
- DTO-Based Architecture
- Exception Handling
- Validation Handling
- Layered Architecture

## Database Features
- MySQL Database Integration
- SQL Operations
- Spring Data JPA
- Hibernate ORM
- Entity Relationship Mapping
- CRUD Operations

---

# 🛠️ Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- JWT Authentication
- REST API Development
- Maven

## Database & ORM
- MySQL
- SQL
- Spring Data JPA
- Hibernate ORM

## Frontend
- HTML
- CSS
- JavaScript

## Tools & Platforms
- Git
- GitHub
- Postman
- IntelliJ IDEA 

---

# 📂 Project Structure

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
 ┣ Screenshots
 ┣ pom.xml
 ┗ README.md
```

---

# 🔌 API Modules

- Authentication APIs
- User APIs
- Restaurant APIs
- Food Item APIs
- Cart APIs
- Cart Item APIs
- Order APIs
- Order Item APIs

---

# 🔐 Security Features

- JWT Token Authentication
- Role-Based Authorization
- Password Encryption
- Protected REST APIs
- Secure API Access

---

# 🗄️ Database Design

## Entities
- User Entity
- Restaurant Entity
- Food Item Entity
- Cart Entity
- Cart Item Entity
- Order Entity
- Order Item Entity

## ORM Features
- JPA Entity Mapping
- Hibernate Relationships
- Repository Layer Implementation
- CRUD Database Operations

---

# 📸 Screenshots

## User Authentication

### Login Page
![Login Page](Screenshots/login.png)

### Register Page
![Register Page](Screenshots/register.png)

---

# 👨‍💼 Admin Module

### Admin Dashboard
![Admin Dashboard](Screenshots/admin-dashboard.png)

### Admin Dashboard - Manage Features
![Admin Dashboard 2](Screenshots/admin-dashboard-2.png)

### Add Restaurant
![Add Restaurant](Screenshots/add-restaurant.png)

### Add Food Item
![Add Food Item](Screenshots/add-food-item.png)

### Manage Orders
![Manage Orders](Screenshots/manage-orders.png)

### Manage Orders - Order Status
![Manage Orders 2](Screenshots/manage-orders-2.png)

### Manage Orders - Update Status
![Manage Orders 3](Screenshots/manage-orders-3.png)

### Manage Orders - Order Completed
![Manage Orders 4](Screenshots/manage-orders-4.png)

---

# 👨‍🍳 Customer Module

### Customer Dashboard
![Customer Dashboard](Screenshots/customer-dashboard.png)

### Search Restaurant
![Search Restaurant](Screenshots/search-restaurant.png)

### View Restaurants
![View Restaurants](Screenshots/view-restaurants.png)

### Search Food Items
![Search Food Items](Screenshots/search-food-items.png)

### View Food Items
![View Food Items](Screenshots/view-food-items.png)

### Add To Cart
![Add To Cart](Screenshots/add-to-cart.png)

### Cart Page
![Cart Page](Screenshots/cart-page.png)

### Empty Cart
![Empty Cart](Screenshots/empty-cart.png)

### Orders Page
![Orders Page](Screenshots/orders.png)

### Order Details Page
![Order Details Page](Screenshots/order-details.png)

---

# ⚙️ How to Run the Project

## Clone Repository

```bash
git clone https://github.com/Varikelavarun369/quickbite-food-delivery-app.git
```

---

## Configure Database

Update the `application.properties` file with your MySQL credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fooddelivery
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## Run Backend

```bash
mvn spring-boot:run
```

---

## Run Frontend

Open the frontend HTML files in your browser.

---

# 📈 Future Improvements

- Online Payment Integration
- Email Notifications
- Real-Time Order Tracking
- Cloud Deployment

---

# 👨‍💻 Author

## Varikela Varun

GitHub:  
https://github.com/Varikelavarun369

---

# 📄 License

This project is developed for learning and portfolio purposes.
