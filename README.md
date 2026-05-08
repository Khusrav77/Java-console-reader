# Java-console-reader

### ⚙️ Tech Stack
Java 23
Spring Boot (MVC)
JDBC
PostgreSQL
Maven
Docker

---

### 🚀 Features
Full CRUD operations for domain entities
PostgreSQL integration with JDBC
DTO-based architecture
Entity ↔ DTO mapping layer
Input validation
Docker support for deployment

---

🏗 Architecture
Controller → Service → Repository → Database
                  ↓
             DTO / Mapper

Layers:
Controller — REST + MVC endpoints
Service — business logic layer
Repository — JDBC-based data access
DTO — data transfer objects
Mapper — object transformation

---

## 🔄 Project Evolution
File-based storage → PostgreSQL migration
JDBC implementation (manual SQL handling)
Introduction of layered architecture
DTO & mapping layer added
Thymeleaf UI integration
Dockerized deployment

---

## 🗄 Database

PostgreSQL is used as the primary relational database with normalized schema and CRUD-oriented design.

docker-compose up --build

---

📌 Key Highlights
Clean Architecture principles
Separation of concerns (SOLID aligned)
JDBC-level database control (no ORM abstraction)
Migration from file storage to relational DB
Hybrid architecture (REST + MVC)
Production-ready project structure


             
