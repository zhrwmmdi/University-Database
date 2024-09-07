# University Database Management System

This is a Java-based project that manages a university's database system, allowing students, teachers, and admins to log in and interact with the system based on their roles. The database schema is modeled after the one in the book *Database System Concepts (7th Edition).*

## Features

### 1. **Student Role:**
   - **Course Enrollment:** Students can enroll in new courses if they have passed the required pre-requisite courses.
   - **View Certificates:** Students can view their certificates and track their academic progress.
   - **Course Removal:** Students can drop courses from their schedule.
   
### 2. **Teacher Role:**
   - **Class Management:** Teachers can view their assigned classes.
   - **Student Management:** Teachers can view the students in their classes and modify their marks.
   
### 3. **Admin Role:**
   - **Full Access:** Admins have complete access to all data tables (students, teachers, courses, enrollments, etc.) and can manage the entire system.

## Database Schema
The project utilizes the database schema presented in the book *Database System Concepts (7th Edition)*. It includes tables such as `student`, `courses`, `instructor`, `takes`, and others, designed to effectively manage a university database.

## Technologies Used
- **Java** for the backend logic.
- **SQL Database** MySQL for managing the data.
- **JDBC** for connecting the Java application to the database.

### Prerequisites
- Install Java Development Kit (JDK)
- Set up an SQL database (with a schema similar to *Database System Concepts (7th Edition)*)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/university-database.git
