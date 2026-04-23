# 🚗 Drive & Thrive

**Drive & Thrive** is a desktop automation system developed with Object-Oriented Programming (OOP) principles, combining traditional car rental services with professional chauffeur (taxi) services under a single platform.

## 🌟 Project Overview
This system allows users to rent vehicles for specific dates or optionally hire a professional driver alongside their rented vehicle. The core of the project is **"The Catch" (Double-Booking Prevention)** algorithm. This algorithm strictly prevents a car or driver from being assigned to different customers at the same time.

## 🚀 Key Features
* **Role-Based Access:** The system features 3 distinct user roles: Admin, Customer, and Driver.
* **Two Different Service Models:**
  * *Classic Rental:* Day-based car rental (With or Without Driver).
  * *Taxi Mode:* Kilometer (KM) based instant driver service.
* **The Catch Algorithm:** A smart booking manager that instantly checks and synchronizes the availability of both vehicles and drivers.
* **Virtual Database:** Dynamic user registration and login system running on RAM (AuthService).

## 🛠️ Technologies Used
* **Language:** Java
* **GUI (Interface):** Java Swing (JFrame)
* **Architecture:** Object-Oriented Programming (Inheritance, Polymorphism, Encapsulation)
* **Development Environment:** Eclipse IDE / VS Code
## 📁 Project Structure (Packages)
The project is designed with a clean, modular structure:
* `com.drivethrive.models`: Data models and classes (User, Customer, Driver, Vehicle, StandardCar, LuxuryCar).
* `com.drivethrive.services`: Business logic and algorithms (AuthService, BookingManager).
* `com.drivethrive.ui`: Graphical User Interface windows (LoginScreen, RegisterScreen, Dashboards).
* `com.drivethrive.main`: The main application runner class.

## ⚙️ Installation & Execution
1. Clone this repository to your local machine:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/Drive-Thrive.git](https://github.com/YOUR_USERNAME/Drive-Thrive.git)
