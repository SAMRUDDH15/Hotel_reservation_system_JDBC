# 🏨 Hotel Management System

![Hotel Banner](https://png.pngtree.com/png-clipart/20190705/original/pngtree-hotel-icon-for-personal-and-commercial-use-png-image_4341927.jpg)

[![Java](https://img.shields.io/badge/Backend-Java-orange)](https://www.java.com/) [![MySQL](https://img.shields.io/badge/Database-MySQL-blue)](https://www.mysql.com/) [![HTML CSS JS](https://img.shields.io/badge/Frontend-HTML/CSS/JS-green)](https://developer.mozilla.org/) [![License](https://img.shields.io/badge/License-MIT-yellow)](https://opensource.org/licenses/MIT)

---

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Database Schema](#database-schema)
5. [System Architecture](#system-architecture)
6. [Installation Guide](#installation-guide)
7. [Contributing](#contributing)
8. [License](#license)

---

## 🌟 Overview

The **Hotel Management System** is a full-stack web application designed to handle the day-to-day tasks of managing a hotel. The application offers functionalities such as booking reservations, canceling bookings, checking available rooms, managing customer data, and handling payments. It provides a seamless experience for both hotel staff and customers.

---

## 🔧 Features

- 🏨 **Room Reservation:** Customers can check room availability and book rooms online.
- ❌ **Cancellation:** Allows customers to cancel reservations within the allowed time frame.
- 🔄 **Booking Modifications:** Modify existing bookings (change dates, room types, etc.).
- 🏷️ **Room Pricing:** pricing based on room types and stay duration.
- 🛏️ **Room Assignment:** Automatically assigns available rooms based on customer preferences.
- 🧾 **Invoice Generation:** Generate detailed invoices for completed stays.
- 📊 **Admin Dashboard:** View hotel occupancy rates, revenues, and customer details.
- 🔒 **Secure Authentication:** Login for both customers and hotel staff with role-based access.

---

## 🛠️ Technology Stack

### Frontend:
- **HTML5**
- **CSS3**
- **JavaScript (Vanilla JS)**

### Backend:
- **Java (Spring Boot Framework)**
- **REST APIs**

### Database:
- **MySQL** for data storage.

---

## 🗃️ Database Schema

The application follows a relational database structure. Below is a simplified schema:

```plaintext
Customers
---------
customer_id  | name        | email         | phone        | address
-------------|-------------|---------------|--------------|-----------------
1            | RUNJAN      | RANJAN@.com   | 1234567890   | 123 Street

Reservations
-------------
reservation_id  | customer_id  | room_id  | check_in_date | check_out_date | status
----------------|--------------|----------|---------------|----------------|---------
1               | 1            | 101      | 2023-10-01    | 2023-10-05     | confirmed

Rooms
------
room_id  | room_number  | room_type  | price_per_night
---------|--------------|------------|-----------------
101      | 101          | Deluxe     | $150



⚙️ System Architecture


   ┌─────────────────────────────────────────────┐
   │            Frontend (HTML/CSS/JS)            │
   └─────────────────────────────────────────────┘
                     ⬇ (API Call)
   ┌─────────────────────────────────────────────┐
   │        Backend (Java - Spring Boot)          │
   └─────────────────────────────────────────────┘
                     ⬇ (Database Query)
   ┌─────────────────────────────────────────────┐
   │                MySQL Database               │
   └─────────────────────────────────────────────┘


🛠️ Installation Guide
1. Clone the repository:
git clone https://github.com/your-username/hotel-management-system.git
cd hotel-management-system

2. Frontend Setup:
Open the frontend/ folder.
Run the index.html file in a browser.

3. Backend Setup:
Navigate to backend/ and run the Java Spring Boot application:

mvn clean install
mvn spring-boot:run
4. Database Setup:
Import the hotel_management.sql file into MySQL:
mysql -u root -p hotel_management < database/hotel_management.sql

5. Access the system:
Customer Portal: http://localhost:8080/customer
Admin Dashboard: http://localhost:8080/admin

📝 Features
1. Reservation System
Book, cancel, or update room reservations.
View available rooms in real-time.
2. Admin Dashboard
Manage reservations and room details.
View statistics and analytics on hotel occupancy.
3. Room Management
Get details on room availability, room number, and types of rooms.
Add new rooms, update pricing, and categorize room types.

🔧 Future Enhancements
Add payment gateway integration.
Implement a loyalty program for frequent customers.
Introduce room service and add-ons to reservations.

🤝 Contributing
We welcome contributions to enhance the Hotel Management System. If you would like to contribute, follow these steps:


📄 License
This project is licensed under the MIT License - see the LICENSE file for details.


👨‍💻 Author
Developed by RANJAN U
Follow me on GitHub:https://github.com/TheAirprogrammer
LinkedIn:https://www.linkedin.com/in/ranjan-u-931286227



