-- JDBC Integration - Employee Management System
-- Database Schema

-- Create database
CREATE DATABASE IF NOT EXISTS employee_management;

-- Select database
USE employee_management;

-- Create employees table
CREATE TABLE IF NOT EXISTS EMPLOYEES (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(150) NOT NULL UNIQUE,
    DEPARTMENT VARCHAR(100),
    SALARY DECIMAL(10,2)
);