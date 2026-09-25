# Banking System

A Java console-based banking system that demonstrates object-oriented programming, inheritance, polymorphism, exception handling, collections, and transaction management.

## Features

* Create Savings Accounts
* Create Current Accounts
* Deposit money
* Withdraw money
* Transfer money between accounts
* Check account balance
* View complete transaction history
* Generate account statements
* Display all accounts
* Enforce minimum balance for Savings Accounts
* Validate deposit and withdrawal amounts
* Handle insufficient funds
* Handle invalid account numbers
* Handle invalid user input
* Automatically generate account numbers

## Technologies Used

* Java 17+
* Object-Oriented Programming
* Collections Framework
* `HashMap`
* `ArrayList`
* Exception Handling
* `LocalDateTime`

## Project Structure

BankingSystem/
│
├── Bank.java
├── BankAccount.java
├── BankingSystemException.java
├── CurrentAccount.java
├── Main.java
├── SavingsAccount.java
└── Transaction.java
   

## Class Overview

### Bank

Manages all bank accounts using a `HashMap`.

Responsibilities:

* Create Savings Accounts
* Create Current Accounts
* Find accounts
* Deposit money
* Withdraw money
* Transfer money
* Check balance
* Generate account statements
* Display all accounts
* Generate account numbers

### BankAccount

An abstract base class for bank accounts.

Contains common account information and operations such as:

* Account number
* Account holder
* Balance
* Transaction history
* Deposit operation

The `withdraw()` method is abstract because different account types can have different withdrawal rules.

### SavingsAccount

Extends `BankAccount`.

It enforces a minimum balance of:

Rs.1000
   
A withdrawal is rejected if it causes the balance to fall below the minimum balance.

### CurrentAccount

Extends `BankAccount`.

It allows withdrawals as long as sufficient funds are available.

### Transaction

Stores transaction information:

* Transaction type
* Amount
* Date and time

Transactions are stored in each account's transaction history.

### BankingSystemException

A custom runtime exception used to handle banking-related errors such as:

* Invalid deposit amount
* Invalid withdrawal amount
* Insufficient funds
* Minimum balance violation
* Account not found
* Invalid transfer

### Main

Provides the console-based menu and accepts input from the user.

## Account Number Generation

Account numbers are automatically generated starting from:

11101
   

Each newly created account receives the next available account number.

For example:
 
11101
11102
11103
   

## Savings Account Rules

Savings accounts must maintain a minimum balance of:
 
Rs.1000
   

For example, if the balance is:
  
Rs.5000
   
the maximum withdrawal allowed is:
  
Rs.4000
   

A withdrawal of Rs.4001 would be rejected because it would leave less than the required minimum balance.

## Transaction Handling

Successful deposits and withdrawals are recorded in the account's transaction history.

For a transfer:

* The sender receives a `WITHDRAW` transaction.
* The receiver receives a `DEPOSIT` transaction.

Each transaction records the date and time using `LocalDateTime`.

## Exception Handling

The application handles two main types of input/errors:

### InputMismatchException

Used when the user enters an incorrect data type.

Example:

      
Enter your choice: abc
   

The program displays an error message instead of terminating.

### BankingSystemException

Used for banking-related validation errors.

Examples:

      
Deposit amount must be greater than 0
Withdrawal amount must be greater than 0
Insufficient funds
Account not found
Minimum balance violation
   

## How to Compile

Open a terminal inside the `BankingSystem` folder.

Compile all Java files:

javac BankingSystem\*.java
   

## How to Run

Run the `Main` class:

java BankingSystem.Main
   

## Menu

      
***** BANKING SYSTEM *****

1. Create Savings Account
2. Create Current Account
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Check Balance
7. View Account Statement
8. View All Accounts
9. Exit
   

## Example Workflow

### 1. Create a Savings Account

      
Enter account holder name: Raj
Savings account created successfully.
Account Number: 11101
Account Holder: Raj
   

### 2. Deposit Money

      
Enter account number: 11101
Enter deposit amount: 10000
Amount deposited successfully.
Current Balance: Rs.10000.00
   

### 3. Withdraw 

      
Enter account number: 11101
Enter withdrawal amount: 3000
Amount withdrawn successfully.
Current Balance: Rs.7000.00
   

### 4. Transfer 

      
Enter sender account number: 11101
Enter receiver account number: 11102
Enter transfer amount: 2000

Amount transferred successfully.
   

### 5. View Statement

The account statement displays:

* Account number
* Account holder
* Current balance
* Transaction history
* Transaction date and time

## Edge Cases Tested

The application handles:

* Negative deposit amount
* Zero deposit amount
* Negative withdrawal amount
* Zero withdrawal amount
* Withdrawal greater than balance
* Savings withdrawal violating minimum balance
* Transfer greater than available balance
* Non-existent account number
* Invalid menu input
* Invalid numeric input
* Same-account transfer

## OOP Concepts Demonstrated

### Abstraction

`BankAccount` is an abstract class containing common account functionality.

### Inheritance

`SavingsAccount` and `CurrentAccount` extend `BankAccount`.

### Polymorphism

The `Bank` class stores different account types using:


Map<String, BankAccount>
   

This allows both `SavingsAccount` and `CurrentAccount` objects to be handled through the `BankAccount` reference.

### Encapsulation

Account fields such as account number, account holder, and balance are kept private/protected and accessed through methods.

### Method Overriding

Both `SavingsAccount` and `CurrentAccount` provide their own implementation of:

withdraw()
   

## Data Structures

### HashMap

Used in `Bank` to store accounts:


Map<String, BankAccount>


The account number is used as the key.

### ArrayList

Used in `BankAccount` to store transaction history:

List<Transaction>


## Author

**Riddhi Manjarekar**

Java Development Internship — Week 2 Assignment

