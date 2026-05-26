# 🏦 Online Banking Application

A professional and secure backend system for an Online Banking Application developed using **Spring Boot**, implementing robust user authentication and financial transaction management.

## 🚀 Features
* **User Authentication & Security**: Secure login/logout system using Spring Security.
* **Account Management**: Create and manage savings/current accounts securely.
* **Transaction System**: Seamless money transfers, deposits, and withdrawal management.
* **Global Exception Handling**: Centralized system to catch errors and return clean API responses.

## 🛠️ Tech Stack
* **Backend**: Java, Spring Boot (Web, Data JPA, Security) 
* **Database**: Embedded File Database / MySQL
* **Build Tool**: Maven

## 💻 Project Structure
* `AccountController` - Handles HTTP requests for account actions.
* `AccountRepository` & `TransactionRepository` - Manages database queries.
* `SecurityConfig` - Secure endpoints and roles configurations.
* `GlobalExceptionHandler` - Ensures the API never crashes and handles bad requests gracefully.
