# **README.md for Quote Generator**

Create a file named `README.md` in your **project root** (same level as `pom.xml`) and paste this:

```markdown
# ✨ Quote Generator API

A **Spring Boot REST API** that generates personalized motivational Quranic quotes with a beautiful web UI. Built for learning Spring Boot architecture patterns and deployed with Docker.

---

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Local Setup](#local-setup)
- [Docker Deployment](#docker-deployment)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Learning Concepts](#learning-concepts)
- [Future Enhancements](#future-enhancements)

---

## ✨ Features

✅ **Personalized Greeting** - App greets users by name  
✅ **Random Quranic Quotes** - 50 curated Islamic quotes  
✅ **Beautiful UI** - Modern, responsive design with gradient styling  
✅ **REST API** - Clean, RESTful endpoints  
✅ **Layered Architecture** - Controller → Service → Model pattern  
✅ **Docker Ready** - One-command deployment  
✅ **Lombok Integration** - Clean, boilerplate-free code  

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Backend language |
| **Spring Boot** | 3.x | Framework |
| **Maven** | 3.x | Build tool |
| **Lombok** | Latest | Reduce boilerplate |
| **HTML/CSS/JS** | Vanilla | Frontend UI |
| **Docker** | Latest | Containerization |

---

## 📦 Prerequisites

Before you begin, ensure you have installed:

- **Java 17+** - [Download](https://www.oracle.com/java/technologies/downloads/#java17)
- **Maven 3.6+** - [Download](https://maven.apache.org/download.cgi)
- **Docker Desktop** - [Download](https://www.docker.com/products/docker-desktop)
- **Git** - [Download](https://git-scm.com/)

---

## 🚀 Local Setup (Without Docker)

### **Step 1: Clone the Repository**

```bash
git clone [https://github.com/YOUR_USERNAME/quote-gen.git](https://github.com/UzmaBagban/quote-generator.git)
cd quote-gen
```

### **Step 2: Build the Project**

```bash
mvn clean install
```

**Expected output:** `BUILD SUCCESS`

### **Step 3: Run Spring Boot**

```bash
mvn spring-boot:run
```

**Expected output:**
```
Started QuoteGeneratorApplication in X.XXX seconds
```

### **Step 4: Access the App**

Open your browser and go to:

```
http://localhost:8080
```

You should see the **Quote Generator UI**! 🎉

### **Step 5: Test the API**

#### Get a random quote:
```bash
curl "http://localhost:8080/api/quotes/hello?name=Uzma"
```

**Response:**
```json
{
  "id": 1,
  "content": "Hey Uzma! 🌟 Here's a quote for you:\n\nAllah does not burden a soul beyond its capacity.",
  "author": "Quran 2:286"
}
```

---

## 🐳 Docker Deployment

### **Option 1: Build & Run Locally**

#### **Step 1: Build the JAR File**

```bash
mvn clean package
```

**Wait until you see:** `BUILD SUCCESS`

#### **Step 2: Build Docker Image**

```bash
docker build -t quote-gen:1.0 .
```

**Expected output:**
```
Successfully tagged quote-gen:1.0
```

#### **Step 3: Run Docker Container**

```bash
docker run -p 8080:8080 quote-gen:1.0
```

**Expected output:**
```
Started QuoteGeneratorApplication in X.XXX seconds
```

#### **Step 4: Access the App**

Open browser: `http://localhost:8080` ✨

---

### **Option 2: Pull from Docker Hub (If Published)**

```bash
docker pull quote-gen:1.0
docker run -p 8080:8080 quote-gen:1.0
```



## 📡 API Endpoints

### **1. Get Personalized Quote**

**Endpoint:**
```
GET /api/quotes/hello?name=uzma
```

**Parameters:**
- `name` (optional, default: "Friend")

**Response:**
```json
{
  "id": 1,
  "content": "Hey Uzma! 🌟 Here's a quote for you:\n\nIndeed, with hardship comes ease.",
  "author": "Quran 94:5-6"
}
```

---

## 📁 Project Structure

```
quote-gen/
├── src/
│   ├── main/
│   │   ├── java/com/smallprojects/quote_generator/
│   │   │   ├── QuoteGeneratorApplication.java (Main entry point)
│   │   │   ├── controller/
│   │   │   │   └── QuoteController.java (HTTP handlers)
│   │   │   ├── service/
│   │   │   │   └── QuoteService.java (Business logic)
│   │   │   └── model/
│   │   │       ├── Quote.java (POJO)
│   │   │       └── QuoteResponse.java (Response wrapper)
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html (UI)
│   │       │   ├── style.css (Styling)
│   │       │   └── script.js (Frontend logic)
│   │       └── application.properties
│   └── test/
├── Dockerfile (Container configuration)
├── pom.xml (Maven dependencies)
└── README.md (This file)
```

---

## 🎓 Learning Concepts

This project demonstrates:

### **Spring Boot Concepts**
- ✅ `@RestController` - REST API handler
- ✅ `@GetMapping` - HTTP GET endpoint mapping
- ✅ `@RequestParam` - Extract query parameters
- ✅ `@Service` - Business logic layer
- ✅ `@Autowired` - Dependency injection
- ✅ Layered architecture (Controller → Service → Model)

### **Java Concepts**
- ✅ POJO (Plain Old Java Object)
- ✅ Lombok annotations (`@Data`, `@NoArgsConstructor`)
- ✅ Collections (ArrayList, Random)
- ✅ ThreadLocalRandom for better randomness

### **Frontend Concepts**
- ✅ HTML forms and input handling
- ✅ CSS gradients and responsive design
- ✅ JavaScript Fetch API
- ✅ Asynchronous programming (async/await)
- ✅ DOM manipulation

### **DevOps Concepts**
- ✅ Docker containerization
- ✅ Multi-stage builds
- ✅ Port mapping
- ✅ JAR packaging

---

## 🔧 Configuration

### **application.properties**
```properties
spring.application.name=quote-generator
server.port=8080
```

### **Dockerfile**
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/quote-generator-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🚀 Future Enhancements

- [ ] **Database Integration** - Persist quotes in MySQL/PostgreSQL
- [ ] **User Authentication** - JWT-based login
- [ ] **Quote Categories** - Filter quotes by category (Patience, Success, etc.)
- [ ] **Pagination** - Browse multiple quotes
- [ ] **Favorites** - Save favorite quotes
- [ ] **Rating System** - Users can rate quotes
- [ ] **API Documentation** - Swagger/OpenAPI
- [ ] **Caching** - Redis for performance
- [ ] **Unit Tests** - JUnit 5 test suite
- [ ] **CI/CD Pipeline** - GitHub Actions deployment

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first.

---



## 👨‍💻 Author

**Uzma Bagwan**
- Software Engineer at Capgemini
- Pursuing M.Tech in Computer Engineering
- Based in Mumbai, India

---


## ✨ Quick Commands Cheat Sheet

```bash
# Local Development
mvn clean install              # Build project
mvn spring-boot:run           # Run locally

# Docker
mvn clean package             # Create JAR
docker build -t quote-gen:1.0 .  # Build image
docker run -p 8080:8080 quote-gen:1.0  # Run container

# Testing
curl "http://localhost:8080/api/quotes/hello?name=Uzma"

# Cleanup
docker stop $(docker ps -q)   # Stop all containers
docker rmi quote-gen:1.0      # Remove image
```

---

**Built with ❤️ for learning and growth** 🌟
