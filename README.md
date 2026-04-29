# 🛒 E-Commerce Backend API

A secure and scalable backend for an E-Commerce application built with **Spring Boot**.
It provides REST APIs for authentication and category management using **JWT-based security**.

---

## 🚀 Features

* User Registration & Login (JWT Authentication)
* Secure APIs with Spring Security
* Category Management (Create, Read, Update, Delete)
* MySQL Database Integration
* RESTful API Design
* Deployment Ready (Render / Cloud)

---

## 🧰 Tech Stack

* **Backend:** Java, Spring Boot
* **Security:** Spring Security, JWT
* **Database:** MySQL
* **Build Tool:** Maven
* **Testing Tool:** Postman

---

## 📁 Project Structure

```
src/main/java/com/ecommerce/ecommerce_backend
│
├── controller        # API Controllers
├── service           # Interfaces
├── service/impl      # Business Logic
├── repository        # Database Access
├── entity            # Database Models
├── dto               # Request/Response Classes
├── config            # Security & JWT Configuration
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```
git clone https://github.com/your-username/ecommerce-backend.git
cd ecommerce-backend
```

---

### 2. Configure Database

Edit `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_32_character_secret_key
```

---

### 3. Build the Project

```
mvn clean install
```

---

### 4. Run the Application

```
java -jar target/*.jar
```

---

## 🔐 Authentication APIs

### ➤ Register

**POST** `/auth/register`

Request Body:

```
{
  "name": "Rohit",
  "email": "rohit@gmail.com",
  "password": "1234"
}
```

---

### ➤ Login

**POST** `/auth/login`

Request Body:

```
{
  "email": "rohit@gmail.com",
  "password": "1234"
}
```

Response:

```
{
  "token": "JWT_TOKEN"
}
```

---

## 📦 Category APIs

> Protected APIs (JWT required)

| Method | Endpoint          | Description        |
| ------ | ----------------- | ------------------ |
| POST   | /categories/admin | Create category    |
| GET    | /categories       | Get all categories |
| PUT    | /categories/{id}  | Update category    |
| DELETE | /categories/{id}  | Delete category    |

---

## 🔑 Authorization

Add JWT token in request headers:

```
Authorization: Bearer <your_token>
```

---

## ☁️ Deployment (Render)

1. Push project to GitHub

2. Create Web Service on Render

3. Add Environment Variables:

   * DB_URL
   * DB_USERNAME
   * DB_PASSWORD
   * JWT_SECRET

4. Commands:

**Build:**

```
mvn clean install
```

**Start:**

```
java -jar target/*.jar
```

---

## ⚠️ Common Issues

* **403 Forbidden** → Check Security Configuration
* **JWT Error** → Ensure same secret key
* **Database Error** → Verify DB credentials

---

## 🔮 Future Enhancements

* Product APIs
* Cart System
* Order Management
* Payment Integration

---

## 👨‍💻 Author

Rohit Thakur

---

## ⭐ Support

If you found this project useful, consider giving it a star ⭐
