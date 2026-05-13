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
![Login Page](Screenshots/login.png)

#### Register Page
![Register Page](Screenshots/register.png)

---

# Admin Module

#### Admin Dashboard
![Admin Dashboard](Screenshots/admin-dashboard.png)

#### Admin Dashboard - Manage Features
![Admin Dashboard 2](Screenshots/admin-dashboard-2.png)

#### Add Restaurant
![Add Restaurant](Screenshots/add-restaurant.png)

#### Add Food Item
![Add Food Item](Screenshots/add-food-item.png)

#### Manage Orders
![Manage Orders](Screenshots/manage-orders.png)

#### Manage Orders - Order Status
![Manage Orders 2](Screenshots/manage-orders-2.png)

#### Manage Orders - Update Status
![Manage Orders 3](Screenshots/manage-orders-3.png)

#### Manage Orders - Order Completed
![Manage Orders 4](Screenshots/manage-orders-4.png)

---

# Customer Module

#### Customer Dashboard
![Customer Dashboard](Screenshots/customer-dashboard.png)

#### Search Restaurant
![Search Restaurant](Screenshots/search-restaurant.png)

#### View Restaurants
![View Restaurants](Screenshots/view-restaurants.png)

#### Search Food Items
![Search Food Items](Screenshots/search-food-items.png)

#### View Food Items
![View Food Items](Screenshots/view-food-items.png)

#### Add To Cart
![Add To Cart](Screenshots/add-to-cart.png)

#### Cart Page
![Cart Page](Screenshots/cart-page.png)

#### Empty Cart
![Empty Cart](Screenshots/empty-cart.png)

#### Orders Page
![Orders Page](Screenshots/orders.png)

#### Order Details Page
![Order Details Page](Screenshots/order-details.png)


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
