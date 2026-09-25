# JDBC Integration – Employee Management System

A console-based **Employee Management System** developed using **Java, JDBC, and MySQL**. This project demonstrates how a Java application can connect to a relational database and perform CRUD (Create, Read, Update, Delete) operations using JDBC.

## Technologies Used

* Java
* JDBC
* MySQL
* MySQL Connector/J
* PreparedStatement
* SQL
* Object-Oriented Programming

## Features

The application provides the following operations:

* Add a new employee
* View all employees
* Update employee details
* Delete an employee
* Automatically create the `EMPLOYEES` table if it does not exist
* Use `PreparedStatement` for database operations
* Use try-with-resources for proper resource management

## Project Structure

            
JDBCIntegration/
│
├── DatabaseConnection.java
├── Employee.java
├── EmployeeDAO.java
├── Main.java
├── mysql-connector-j-9.3.0.jar
└── README.md
      

## Database Setup

First, create the database in MySQL:

CREATE DATABASE employee_management;
      

The application uses the following table:

CREATE TABLE IF NOT EXISTS EMPLOYEES(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(150) NOT NULL UNIQUE,
    DEPARTMENT VARCHAR(100),
    SALARY DECIMAL(10,2)
);
      

The `createTables()` method in `EmployeeDAO` can create this table automatically.

## Database Configuration

The database connection is configured in `DatabaseConnection.java`.

    
private static final String URL =
        "jdbc:mysql://localhost:3306/employee_management";

private static final String USER = "USER_NAME";
private static final String PASSWORD = "USER_PASSWORD";
      

Before running the application, replace the placeholders with your local MySQL credentials:


private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
      

**Do not commit real database credentials to GitHub.**

## How to Compile

Make sure the MySQL Connector/J JAR file is present in the project directory.

From the `JDBCIntegration` directory, compile the project using:

  
javac -cp "JDBCIntegration\mysql-connector-j-9.3.0.jar"  JDBCIntegration\*.java
      

## How to Run

Run the application using:

java -cp ".;JDBCIntegration\mysql-connector-j-9.3.0.jar" JDBCIntegration.Main
      

## Application Menu

            
===== Employee Management System =====
1. Add Employee
2. View All Employees
3. Update Employee
4. Delete Employee
5. Exit

Enter your choice:
      

### Add Employee

Allows the user to enter:

* Name
* Email
* Department
* Salary

The employee record is inserted into the MySQL database.

### View All Employees

Retrieves all employee records from the `EMPLOYEES` table and displays them in the console.

Example:

            
1 | Raj | raj@gmail.com | Software Development | 40000.0
2 | Amit | amit@gmail.com | Testing | 35000.0
      

### Update Employee

The user enters the employee ID and updated details. The corresponding record is updated in the database.

### Delete Employee

The user enters an employee ID and the corresponding employee record is deleted from the database.

## Classes

### `DatabaseConnection`

Responsible for establishing a JDBC connection with the MySQL database.

### `Employee`

A model class representing an employee. It contains:

* Employee ID
* Name
* Email
* Department
* Salary

### `EmployeeDAO`

Handles database operations using JDBC, including:

* Creating the employee table
* Inserting employees
* Retrieving employees
* Updating employees
* Deleting employees

### `Main`

Provides the console-based user interface and menu for interacting with the Employee Management System.

## JDBC Concepts Demonstrated

This project demonstrates:

* JDBC database connectivity
* `DriverManager`
* `Connection`
* `Statement`
* `PreparedStatement`
* `ResultSet`
* SQL CRUD operations
* Try-with-resources
* `SQLException` handling
* DAO pattern
* Encapsulation
* Parameterized SQL queries

## Security

`PreparedStatement` is used for SQL operations involving user input. This helps protect against SQL injection by using parameterized queries.

Database credentials are represented using placeholders in the repository and should be replaced locally when running the project.

