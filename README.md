# bank-management-system
A Java-based console application for managing bank operations including customer accounts, transactions, and reporting. Built with OOP principles and a modular service architecture.
---

## Project Structure
src/ 
├── com.cts.model/ # Domain models (Customer, BankAccount, Transaction) 
├── com.cts.service/ # Service interfaces 
├── com.cts.serviceimpl/ # Service implementations 
└── com.cts/Main.java # Console interface


---

## Features

### Customer Operations
- Add new customer
- View own account details
- View transaction history
- View current bank balance

### Transaction Operations
- Deposit funds
- Withdraw funds
- Transfer funds between accounts

### Reporting
- Generate individual customer reports
- Generate full bank summary (accessible to employees)

---

## Technologies Used

- Java 17+
- Console-based UI
- Object-Oriented Design (OOP)

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/L-Hemath-Kumar/bank-management-system.git

2. Navigate to the project directory: 
   cd bank-management-system

3. Compile and run:
   javac com/cts/Main.java
   java com.cts.Main

Notes
All data is stored in memory (no database or file persistence).

This project is ideal for learning OOP, service architecture, and console interaction in Java.

Role-based access control is not implemented in this version.

Contributing
Pull requests are welcome! If you'd like to add features like file storage, GUI, or role-based access, feel free to fork and enhance.
