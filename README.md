Payment Gateway Simulation

Project Overview : 
This project is a backend simulation of a payment gateway system, built with Spring Boot.
It replicates the core logic behind real-world online payment processing — from user account management to secure transaction handling — offering a simplified yet realistic look at how digital payments work.

⚙️ Key Features

👤 User Management – Create, update, and manage users with assigned roles (Admin, User).

💳 Payment Methods – Add and manage virtual cards or wallets linked to users.

💰 Transactions – Simulate payments between accounts with different statuses (Pending, Success, Failed).

📜 Audit Logs – Automatically record every transaction for traceability.

🧠 Fraud Detection – Detect and flag suspicious transactions based on configurable thresholds.

🔐 Security Layer – Password encryption and secure data handling (Spring Security ready).

🛠️ RESTful API – Fully documented endpoints via Swagger for easy testing and integration.

🏗️ Tech Stack

Backend: Spring Boot (Java 17)

Database: MySQL

Mapping: MapStruct (Entity ↔ DTO)

API Documentation: Swagger / Springdoc OpenAPI

Security: Spring Security (Password Encoding)

🎯 Purpose

The goal of this project is to simulate the core workflow of an electronic payment system — the same type of functionality used in Big Payment Companies, which manage issuing, acquiring, and transaction processing.

🚀 Future Improvements

Integrate real-time fraud detection with AI rules

Add JWT-based authentication

Develop a simple Angular or React dashboard for visualization
