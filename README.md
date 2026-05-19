# 🍰 TastyBakers Cake Order Management System

## 📌 Project Overview

TastyBakers Cake Order Management System is a Java + MySQL based application developed to manage cake orders, customer details, and bakery operations efficiently.

The system automates:

- Cake Management
- Customer Management
- Order Management
- Database Storage and Retrieval

This project is developed using Core Java, JDBC, and MySQL following layered architecture and DAO design pattern.

---

# 🎯 Project Objectives

- Simplify cake order placement and tracking
- Manage customer and cake details efficiently
- Modify cake and customer information easily
- Store and retrieve data reliably using MySQL database

---

# 🛠 Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application Development |
| JDBC | Database Connectivity |
| MySQL | Database Management |
| Eclipse IDE | Development Tool |
| Git & GitHub | Version Control |

---

# 🏗 Project Modules

## 1️⃣ Cake Management

- Add new cakes
- Update cake details
- View cake information
- View all cakes
- Deactivate unavailable cakes

---

## 2️⃣ Customer Management

- Add customer details
- Update customer information
- View customer profiles
- Deactivate customers

---

## 3️⃣ Order Management

- Place customer orders
- Generate unique order IDs
- View order history
- Cancel orders within same day

---

# 📂 Project Structure

```text
src
│
├── dao
│     ├── cakeDAO.java
│     ├── customerDAO.java
│     └── orderDAO.java
│
├── model
│     ├── cake.java
│     ├── customer.java
│     └── order.java
│
├── service
│     ├── cakeService.java
│     ├── customerService.java
│     └── orderService.java
│
├── util
│     └── DatabaseUtil.java
│
├── exception
│     └── OrderNotCancelledException.java
│
└── ui
      └── MainUI.java
```

---

# 💡 Java Concepts Covered

## ✅ Core Java

- Classes and Objects
- Constructors
- Encapsulation
- Packages
- Methods
- Exception Handling
- OOP Principles

---

## ✅ JDBC Concepts

- JDBC Driver
- Connection
- DriverManager
- PreparedStatement
- ResultSet
- CRUD Operations

---

## ✅ Database Concepts

- MySQL Database
- Table Creation
- Primary Key
- Foreign Key
- Auto Increment
- Relational Database

---

## ✅ Design Concepts

- Layered Architecture
- DAO Design Pattern
- Service Layer
- Utility Layer

---

# 🗄 Database Schema

## Database Name

```sql
tastybakers
```

---

# 🎂 Cakes Table

```sql
CREATE TABLE Cakes (
    cakeId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    flavor VARCHAR(255),
    price DECIMAL(10,2),
    isActive BOOLEAN
);
```

---

# 👤 Customers Table

```sql
CREATE TABLE Customers (
    customerId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    contact VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    isActive BOOLEAN
);
```

---

# 📦 Orders Table

```sql
CREATE TABLE Orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    cakeId INT,
    quantity DECIMAL(10,2),
    price DECIMAL(10,2),
    orderDate DATE,
    
    FOREIGN KEY (customerId)
    REFERENCES Customers(customerId),

    FOREIGN KEY (cakeId)
    REFERENCES Cakes(cakeId)
);
```

---

# 🔌 Database Connectivity

The project uses JDBC for database connectivity.

`DatabaseUtil.java` is responsible for:

- Loading JDBC Driver
- Creating database connection
- Handling SQL exceptions
- Providing connection to DAO classes

---

# ⚙ Features Implemented

## Cake Operations

✅ Add Cake  
✅ Update Cake Name  
✅ Update Cake Flavor  
✅ Update Cake Price  
✅ View Cake By ID  
✅ View All Cakes  
✅ Deactivate Cake  

---

# ▶ Flow of Operations

## Startup

- User opens application
- Main menu displayed

---

## Cake Flow

- Add cake details
- Modify cake information
- Display cakes
- Deactivate unavailable cakes

---

## Customer Flow

- Add customer details
- Update customer profile
- View customer information

---

## Order Flow

- Place order
- Generate order ID
- View order history
- Cancel order within same day

---

# ▶ How to Run the Project

## Step 1

Clone repository:

```bash
git clone https://github.com/antonyjudu/TastyBakers-Cake-Management-System.git
```

---

## Step 2

Open project in Eclipse IDE.

---

## Step 3

Install MySQL.

---

## Step 4

Create database:

```sql
CREATE DATABASE tastybakers;
```

---

## Step 5

Add MySQL JDBC Connector JAR.

---

## Step 6

Run:

```text
MainUI.java
```

---

# 🖥 Sample Output

```text
Database Connected
Cake Added Successfully

ALL CAKES
------------------------
Cake ID : 1
Name    : Black Forest
Flavor  : Chocolate
Price   : 650.0
Active  : true
```

---

# 🔄 CRUD Operations

| Operation | Status |
|---|---|
| Create | ✅ |
| Read | ✅ |
| Update | ✅ |
| Deactivate | ✅ |

---

# 🚀 Future Enhancements

- Menu Driven UI
- Admin Login
- Search Functionality
- Customer Module
- Order Module
- Order Cancellation Exception
- Inventory Management

---

GitHub Repository:

https://github.com/antonyjudu/TastyBakers-Cake-Management-System

---

# 📌 Conclusion

This project demonstrates practical implementation of Java, JDBC, MySQL, CRUD operations, DAO design pattern, and layered architecture in a real-world Cake Order Management System.
