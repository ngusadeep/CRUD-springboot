# 🧾 Spring Boot CRUD Application – Customer Management

A simple **Spring Boot** CRUD application to manage customer data, built using **Java**, **PostgreSQL**, and **Spring Data JPA**. This app performs basic operations like adding, viewing, updating, and deleting customer records and preloads sample data on startup.

---

## 📦 Features

✅ Add New Customers  
✅ View All Customers  
✅ Update Customer Details  
✅ Delete Customers  
✅ Tracks Customer Creation Timestamp  
✅ Responsive Table with Bootstrap  
✅ Preloads Dummy Data

---

## 🧰 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Bootstrap 5** (for responsive UI)
- **Thymeleaf** *(for web UI)*

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/webapp/CRUD_springboot/
│   │       └── customers/
│   │           ├── Customer.java
│   │           ├── CustomerRepository.java
│   │           ├── CustomerService.java
│   │           ├── CustomerController.java
│   │           └── CustomerConfig.java
│   └── resources/
│       ├── application.properties
│       └── templates/  # if using Thymeleaf
```

---

## 🧪 Preloaded Customer Data

The application automatically loads 15 customers on startup using `CustomerConfig.java`. This helps with quick testing and demonstration.

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 21+
- Maven
- PostgreSQL installed and running

---

### 🛠️ Setup Instructions

1. **Clone the project**

```bash
git clone https://github.com/your-username/springboot-crud-customers.git
cd springboot-crud-customers
```

2. **Configure PostgreSQL**

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/customerdb
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# To allow viewing on mobile device
server.address=0.0.0.0
```

3. **Run the project**

```bash
./mvnw spring-boot:run
```

4. **Visit in browser**

```text
http://localhost:8080
```

---

### 📱 View on Phone Browser (Same Wi-Fi)

- Get your computer IP:
  - On Windows: `ipconfig`
  - On Mac/Linux: `ifconfig`

- On your phone’s browser, open:

```text
http://<your-pc-ip>:8080
```

Example:

```text
http://192.168.0.101:8080
```

---

## 🖥️ Responsive Table with Bootstrap

Wrap your `<table>` with Bootstrap's responsive class:

```html
<div class="table-responsive">
  <table class="table table-striped table-bordered">
    <!-- Table Content Here -->
  </table>
</div>
```

---

## 📘 DTO vs Bean – Quick Explanation

- **@Bean**: Used to tell Spring to treat a method as a bean definition (instantiated and managed by the Spring container).
- **DTO (Data Transfer Object)**: A plain class used to transfer data (like from frontend to backend or between layers). It usually only contains fields and getters/setters (no logic).

---

## 📃 License

This project is licensed under the [MIT License](LICENSE).

---

## 👤 Author

**Your Name**  
🔗 GitHub: [@ngusadeep](https://github.com/yourusername)

---

## 🙌 Contributions

Feel free to fork, improve, and submit a PR.

---