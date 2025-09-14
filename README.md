# Grocery-Ordering-Platform
Grocery Ordering Platform built with Spring Boot microservices (User, Product, Cart, Order). Uses Firebase Auth for secure login &amp; roles, PostgreSQL for storage, API Gateway for routing, and Config Server for centralized config. Fully containerized with Docker.

📌 Overview

This project is a microservices-based Grocery Ordering Platform where users can browse grocery items, add them to a cart, and place orders.

Authentication & Authorization: Firebase Authentication (Consumer & Admin roles).

Databases: Each service has its own PostgreSQL database.

Communication: REST APIs via Spring Cloud Gateway.

Configuration: Centralized with Spring Cloud Config Server.

Deployment: Fully containerized with Docker & Docker Compose.

🏗️ Project Structure
grocery-ordering-platform/
│
├── config-server/          # Centralized configuration (Spring Cloud Config)
│   └── src/main/resources/
│       └── application.yml
│
├── api-gateway/            # Spring Cloud Gateway (routes to microservices)
│   └── src/main/resources/
│       └── application.yml
│
├── user-service/           # Handles users, roles, Firebase Auth
│   ├── src/main/java/com/grocery/userservice
│   └── src/main/resources/
│       └── application.yml
│
├── product-service/        # Manages grocery products catalog
│   ├── src/main/java/com/grocery/productservice
│   └── src/main/resources/
│       └── application.yml
│
├── cart-service/           # Handles shopping cart logic
│   ├── src/main/java/com/grocery/cartservice
│   └── src/main/resources/
│       └── application.yml
│
├── order-service/          # Manages orders and history
│   ├── src/main/java/com/grocery/orderservice
│   └── src/main/resources/
│       └── application.yml
│
├── docker-compose.yml      # Runs all services + PostgreSQL containers
├── README.md               # Project documentation

🔄 Project Flow

User Registration & Login

Consumer signs up via Firebase Auth.

Admin account is pre-created in DB.

Browse Products

User fetches product list via API Gateway → Product Service.

Add to Cart

User adds items via API Gateway → Cart Service.

Place Order

Cart details sent via Order Service, stored in DB.

Admin Role

Can update product catalog and manage order status.

⚙️ How to Run
1️⃣ Clone Repo
git clone https://github.com/your-username/grocery-ordering-platform.git
cd grocery-ordering-platform

2️⃣ Configure Firebase

Add your Firebase credentials (service account JSON) in user-service/resources/.

Update Firebase configs in application.yml.

3️⃣ Run with Docker Compose
docker-compose up --build


This will start:

config-server

api-gateway

user-service

product-service

cart-service

order-service

PostgreSQL databases

4️⃣ Access Services via API Gateway

User Service → http://localhost:8080/user/...

Product Service → http://localhost:8080/product/...

Cart Service → http://localhost:8080/cart/...

Order Service → http://localhost:8080/order/...
