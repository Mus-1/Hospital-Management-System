# 🏥 Hospital Management System (Spring MVC + JSP + JDBC)

> A full-stack Java web application built using **Spring MVC**, **JSP**, and **JDBC**, following the **MVC (Model–View–Controller)** architecture.  
> The system manages doctors, patients, and user logins with CRUD operations and MySQL database integration.

## ⚙️ Tech Stack
- **Java 8+**
- **Spring MVC 5**
- **JSP & JSTL**
- **JDBC (MySQL Database)**
- **Apache Tomcat 9+**
- **Maven Build Tool**
- **Eclipse / IntelliJ IDEA**


## 📂 Project Structure
```
Hospital-Management-System/
│
├── pom.xml
│
├── src/
│ ├── main/java/
│ │ ├── model/
│ │ │ ├── Doctor.java
│ │ │ ├── Patient.java
│ │ │ └── Login.java
│ │ │
│ │ ├── dao/
│ │ │ ├── DoctorDao.java
│ │ │ ├── PatientDao.java
│ │ │ └── LoginDao.java
│ │ │
│ │ └── controller/
│ │ ├── DoctorController.java
│ │ ├── PatientController.java
│ │ └── LoginController.java
│ │
│ ├── main/resources/
│ │ └── spring-servlet.xml
│ │
│ └── main/webapp/
│ ├── WEB-INF/
│ │ ├── web.xml
│ │ └── jsp/
│ │ ├── index.jsp
│ │ ├── doctorform.jsp
│ │ ├── doctoreditform.jsp
│ │ ├── patientform.jsp
│ │ ├── patienteditform.jsp
│ │ ├── loginForm.jsp
│ │ ├── logineditform.jsp
│ │ ├── viewdoctor.jsp
│ │ ├── viewpatient.jsp
│ │ └── viewLogin.jsp
│
└── .gitignore
```

## 🗄️ Database Setup
1. Create a database in MySQL:

```
CREATE DATABASE hospitaldb;
```

2. Create tables for doctors, patients, and logins based on your DAO structure.

3. Update DB credentials inside spring-servlet.xml:

```
<property name="url" value="jdbc:mysql://localhost:3306/hospitaldb"/>
<property name="username" value="YOUR_DB_USERNAME"/>
<property name="password" value="YOUR_DB_PASSWORD"/>
```

⚙️ Configuration Files
File	Purpose
web.xml	Defines DispatcherServlet and URL mapping
spring-servlet.xml	Configures Spring beans, view resolver, and data source
pom.xml	Manages dependencies (Spring MVC, MySQL connector, JSTL, Servlet API)

🚀 How to Run
1. Import the project into Eclipse / IntelliJ as a Maven web project.

2. Configure Apache Tomcat (v9 or higher).

3. Build the project:

```
mvn clean install
```
4. Deploy the WAR to Tomcat.

5. Run in browser:
```
http://localhost:8080/Hospital-Management-System/
```

💡 Features
✅ CRUD operations for doctors, patients, and login users

✅ Follows MVC architecture using Spring framework

✅ JSP views for user-friendly interface

✅ JDBC integration with MySQL database

✅ Maven-based build and dependency management

✅ Easy deployment on Apache Tomcat

🧠 Concepts Demonstrated
Spring MVC Controller–DAO–Model interaction

Form data binding and validation

JDBC connection pooling

JSP–Servlet communication

MVC separation of concerns

