# CRUD_App


A simple CRUD (Create, Read, Update, Delete) application in Java using JDBC and MySQL.

## Features

1. **Create:** Insert new data into the table.
2. **Read Specific Row:** Retrieve data for a specific ID from the table.
   - If the entered ID is not available, the program displays a message that the data is not available.
3. **Read All Data:** Retrieve and display the entire table data.
4. **Update Specific Row:** Modify the data/name of a specific row in the table.
5. **Delete Specific Data:** Remove a specific row from the table.
   - If the entered ID for deletion is not available, the program displays a message that the data is not available.
6. **Exit:** Quit the application.

## Description

The project consists of five different Java classes:

1. **App:** Contains a switch statement with cases for each CRUD operation.
2. **Customer:** Represents a customer entity with getter functions for all columns and a method to return customer data as a string.
3. **CustomerDao:** Stores functions for CRUD operations, including create, read, update, and delete.
4. **DB:** Includes methods to check database availability and establish a connection.
5. **Query:** Separates queries for each CRUD operation.

## Technologies Used

- Core Java
- JDBC (Java Database Connectivity)
- MySQL

## IDE Used

- Eclipse IDE for Enterprise Java and Web Developers

## Usage

1. **Setup:**
   - Ensure you have a MySQL database set up.
   - Create a database named `db` in MySQL.
   - Create a table named `customer` in the `db` database.

  ```
  CREATE DATABASE db;
  USE db;
  ```

  
   ```sql
   CREATE TABLE customer (
       id INT ,
       name VARCHAR(30),
       product VARCHAR(30);
       price INT(10)
       // Add other columns as needed
   );
  ```
2. **Change in DB file:**
   - Make sure to replace ***** with your database password.

## Learning Mode ON 💛

**Enjoy using your CRUD application in Java! If you have any questions or encounter issues, feel free to open an [issue](https://github.com/yourusername/CRUD_App/issues).**

