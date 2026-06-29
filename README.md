# Course Management System

A backend RESTful service built using Spring Boot to simulate a real-world course management platform.

Implemented using clean layered architecture with JPA/Hibernate for data persistence, transaction management, request validation, exception handling, and relational database modeling.

Integrated containerization using Docker, database migration management with Flyway.

---

## 🚀 Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- RESTful API  
- Bean Validation (Jakarta Validation)  
- Global Exception Handling  
- Maven Build Tool  
- Relational Database (MySQL)  
- Lombok (`@Slf4j`, `@Data`, etc.)

---

## 📂 Project Structure

src/main/java
├── controller → REST endpoints
├── service → Business logic layer
├── repository → JPA repositories
├── entity → Domain models & relationships
├── dto → Request/response models
├── exception → Custom exceptions & handlers
└── config → Application configuration

This layered approach follows **clean architecture principles** used in enterprise backend systems.
---

## 🎯 Features Implemented

- Student & Course management  
- Student profile creation  
- Entity relationships (One-to-Many / Many-to-One)  
- DTO-based API design  
- Validation using annotations  
- Centralized exception handling  
- Transactional service layer  
- RESTful API structure following best practices  
- Pagination & sorting for listing students  

---

## 🧠 Concepts Demonstrated

- JPA Entity Lifecycle (Managed → Detached → Removed)  
- Persistence Context behavior  
- Cascading operations vs manual relationship handling  
- Transaction management with `@Transactional`  
- Lazy vs Eager loading  
- JPQL-based updates and deletes  
- Proper separation of Controller → Service → Repository  
- Validation-driven API contracts  
- Exception-to-HTTP response mapping  

---

## 🔧 How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/lhossainduet094026/course-management.git
cd course-management
2️⃣ Build the Project
mvn clean install
3️⃣ Run the Project
mvn spring-boot:run
Application will start at:
http://localhost:8080

📡 API Endpoints
Method	Endpoint	Description	Request / Response
POST	/api/v1/students	Create a new student	Body: StudentCreateRequestDto
Response: StudentResponseDto
GET	/api/v1/students/{id}	Get student by ID	Response: StudentResponseDto
GET	/api/v1/students	List all students	Response: List of StudentResponseDto
PUT	/api/v1/students/{id}	Update student	Body: StudentUpdateRequestDto
Response: StudentResponseDto
DELETE	/api/v1/students/{id}	Delete student	No content
GET	/api/v1/students/{id}/courses	Get courses enrolled by student	Response: List of CourseResponseDto
POST	/api/v1/students/{studentId}/courses/{courseId}	Enroll student in course	No body, Response: success message
POST	/api/v1/students/{studentId}/profile	Create profile for student	Body: ProfileCreateRequestDto
Response: ProfileResponseDto
GET	/api/v1/students/paged	Get paged list of students	Response: Page<StudentResponseDto>

🔹 Example JSON Requests / Responses

Create Student Request:

{
  "name": "Lokman Hossain",
  "email": "lokman@example.com",
  "phone": "017xxxxxxxx"
}


Create Student Response (201 Created):

{
  "id": 1,
  "name": "Lokman Hossain",
  "email": "lokman@example.com",
  "phone": "017xxxxxxxx"
}


Enroll Student in Course Response:

{
  "message": "Course enrolled successfully"
}

🧪 Purpose of This Project

This is a hands-on learning project designed to:

Strengthen understanding of JPA internals

Practice transaction-safe CRUD operations

Explore ORM relationship management

Simulate real backend service design

📈 Future Improvements

Add Spring Security + JWT authentication

Pagination & filtering support

Docker containerization

Integration testing

Role-based access (Admin / Instructor / Student)

👨‍💻 Author

Lokman Hossain
