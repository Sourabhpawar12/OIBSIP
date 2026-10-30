# ATM Interface – Java Development

## Project Description
This project is a console-based ATM Interface developed using Java. It simulates basic banking operations and allows users to securely log in using a User ID and PIN.

## Features
- User authentication with User ID and PIN.
- Access denied after 3 incorrect login attempts.
- Check account balance.
- Deposit money.
- Withdraw money with balance validation.
- Transfer money between accounts.
- Transaction history using ArrayList.
- Input validation.
- Exit option.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- Java Date and Time API

## Project Structure
```text
JavaDevelopment-Task3-ATMInterface/
│
├── Main.java
├── ATM.java
├── Account.java
├── Bank.java
├── Transaction.java
└── README.md
```

## Demo Login Credentials

| User ID | PIN | Initial Balance |
|---|---|---:|
| user1 | 1234 | ₹5000 |
| user2 | 4321 | ₹3000 |

## How to Run

1. Open the project folder in VS Code.
2. Open the terminal.
3. Compile the Java files:

```bash
javac Main.java ATM.java Account.java Bank.java Transaction.java
```

4. Run the application:

```bash
java Main
```

## Learning Outcomes
- Practised Java fundamentals.
- Learned Object-Oriented Programming concepts.
- Worked with multiple Java classes.
- Used ArrayList to maintain transaction history.
- Implemented banking operations and input validation.

## Limitations
- This is an educational ATM simulation, not a real banking application.
- Account data and transaction history are stored in memory.
- Data resets when the application is closed.

## Author
Sourabh Pawar

## Internship
OASIS INFOBYTE – Java Development Internship
