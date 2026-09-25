# Student Management System

A console-based **Student Management System** developed in Java. The application allows users to add, view, search, update, and delete student records. It also calculates the class average grade and persists student data using Java object serialization.

## Features

* Add new student records
* Display all students in a formatted table
* Search students by:

  * Student ID
  * Student name
* Update student grade
* Update student subjects
* Delete student records with confirmation
* Calculate class average grade
* Prevent duplicate student IDs
* Validate user input
* Prevent duplicate subjects for the same student
* Save student records to a file
* Load previously saved student records when the application starts

## Technologies Used

* **Java 17+**
* **Object-Oriented Programming (OOP)**
* **ArrayList**
* **Scanner**
* **Exception Handling**
* **Java Serialization**
* **File I/O**

## Project Structure

      
StudentManagementSystem/
│
├── Main.java
├── Student.java
├── StudentManager.java
├── README.md
└── students.dat
   

### Class Responsibilities

#### `Student`

Represents a student record.

It contains:

* Student ID
* Name
* Age
* Grade
* Subjects

It also implements `Serializable` so that student objects can be stored in a file.

#### `StudentManager`

Manages the collection of students and provides operations for:

* Adding students
* Displaying students
* Searching students
* Updating grades
* Updating subjects
* Deleting students
* Calculating the class average
* Saving data
* Loading data

#### `Main`

Acts as the entry point of the application.

It:

* Displays the console menu
* Accepts user input
* Validates input
* Creates `Student` objects
* Calls the appropriate `StudentManager` methods

## Application Menu


*** Student Management System ***

1. Add Student
2. Display Students
3. Search Student
4. Update Grade
5. Update Subjects
6. Delete Student
7. Calculate Average
8. Exit


## Input Validation

The application validates user input to prevent invalid data.

Examples:

* Student ID must be greater than `0`
* Student ID must be unique
* Name cannot be empty
* Age must be between `1` and `100`
* Grade must be between `0` and `100`
* At least one subject must be entered
* Subject names cannot be empty
* Duplicate subjects are not allowed
* Invalid numeric input is handled without terminating the application
* Delete operation requires user confirmation

## Search

Students can be searched using either:

* Student ID
* Student name

Name searches are **case-insensitive**.

For example:


Search Student by ID or Name:
riddhi


will also match:

Riddhi
RIDDHI
Riddhi Manjarekar


when the complete name matches the stored student name.

## Grade Average

The application calculates the class average using the arithmetic mean of all student grades.

For example:

Student 1 → 80
Student 2 → 70
Student 3 → 90

Class average = (80 + 70 + 90) / 3
              = 80


The result is displayed as:

Class average grade: 80.00%


## Data Persistence

The application uses **Java Object Serialization** to persist student records.

When the application exits through option `8`, the current student list is saved to:

students.dat

When the application starts, previously saved records are loaded from the same file.

The following classes are involved in persistence:

ObjectOutputStream
ObjectInputStream
FileOutputStream
FileInputStream
Serializable


The `Student` class implements `Serializable` so that student objects can be written to and read from the file.

## How to Run

### 1. Open the project directory

The project should have the following structure:

Java-Week2-Assignment/
│
└── StudentManagementSystem/StudentManagementSystem/
    ├── Main.java
    ├── Student.java
    └── StudentManager.java


### 2. Compile the project

Open the terminal in the `Java-Week2-Assignment/StudentManagement` directory and run:


javac StudentManagementSystem\*.java


### 3. Run the application

java StudentManagementSystem.Main


### 4. Use the menu

Choose an option from `1` to `8` and follow the prompts.

## Example Output


*** Student Management System ***

1. Add Student
2. Display Students
3. Search Student
4. Update Grade
5. Update Subjects
6. Delete Student
7. Calculate Average
8. Exit

Enter your choice: 1

Enter student details:
Enter student ID: 101
Enter student name: Rajendra
Enter student age: 23
Enter student grade: 85
Enter number of subjects: 3

Now enter subject names:
Subject 1:
Java
Subject 2:
Database
Subject 3:
Web Development

Student added


### Display Students


ID         Name                 Age        Grade      Subjects
---------------------------------------------------------------------------------------
101        Rajendra             23         85.00      Java, Database, Web Development


### Calculate Average


*** AVERAGE ***

Class average grade: 85.00%


## OOP Concepts Used

The project demonstrates several Java Object-Oriented Programming concepts:

### Encapsulation

Student data is stored in private fields and accessed through getters and setters.


private Long id;
private String name;
private int age;
private double grade;


### Classes and Objects

The application uses separate classes for student data, student management, and application control.

### Abstraction

Student management operations are handled by `StudentManager`, while `Main` handles user interaction.

### Composition

`StudentManager` maintains a collection of `Student` objects.


private List<Student> students = new ArrayList<>();


## Collections Used

The application uses an `ArrayList` through the `List` interface:


private List<Student> students = new ArrayList<>();


This collection stores multiple student records and supports adding, searching, and removing students.

## Exception Handling

The application uses exception handling to manage invalid input and file-related errors.

For example:


try {
    return Integer.parseInt(sc.nextLine().trim());
} catch (NumberFormatException e) {
    System.out.println("Invalid input! Please enter a number.");
}


File operations also handle:

* `IOException`
* `ClassNotFoundException`

## Project Flow


              ┌──────────────┐
              │     Main     │
              └──────┬───────┘
                     │
                     │ User Input
                     ▼
          ┌────────────────────┐
          │   StudentManager   │
          └─────────┬──────────┘
                    │
                    │ Manages
                    ▼
             ┌────────────┐
             │  Student   │
             └────────────┘
                    │
                    │ Serialization
                    ▼
             ┌────────────┐
             │students.dat│
             └────────────┘


## Learning Objectives

This project was developed to practice:

* Java fundamentals
* Object-Oriented Programming
* Classes and objects
* Encapsulation
* Collections
* ArrayList
* Exception handling
* User input using Scanner
* Input validation
* CRUD operations
* File handling
* Object serialization
* Basic application structure



## Author

**Riddhi Manjarekar**

Java Development Internship — Week 2 Assignment
