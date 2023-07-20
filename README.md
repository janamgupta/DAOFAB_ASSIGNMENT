# Parent-Child Transaction Management System

The Parent-Child Transaction Management System is a web application that manages transaction data containing parent transactions and their corresponding child transactions. It consists of a backend developed using Spring Boot and a frontend developed using React.

## Backend (Spring Boot)

### Description

The backend of the Parent-Child Transaction Management System is developed using Spring Boot framework. It provides RESTful APIs to fetch parent transactions, child transactions, and perform pagination and sorting operations.

### Prerequisites

- Java 8 or higher
- Maven

### Setup

1. Clone the backend repository:
   ```bash
   git clone https://github.com/janamgupta/DAOFAB_ASSIGNMENT.git
   cd parent-child-transaction-backend
   ```

2. Build and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### API Endpoints

- **GET /parents**: Fetch a paginated list of parent transactions. Supports pagination and sorting by parent id.
- **GET /parents/{parentId}**: Fetch a specific parent transaction by its ID.
- **GET /parents/{parentId}/children**: Fetch child transactions for a specific parent transaction.

## Frontend (React)

### Description

The frontend of the Parent-Child Transaction Management System is developed using React framework. It consumes the RESTful APIs provided by the backend to display and manage parent and child transactions.

### Prerequisites

- Node.js
- npm

### Setup

1. Clone the frontend repository:
   ```bash
   git clone https://github.com/janamgupta/DAOFAB_ASSIGNMENT.git
   cd parent-child-transaction-frontend
   ```

2. Install the required dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

### Features

- View paginated list of parent transactions.
- Sort parent transactions by parent id.
- View child transactions for a specific parent transaction.

## Folder Structure

```
parent-child-transaction-backend/
  ├── src/
  │   └── main/
  │       └── java/
  │           └── com/
  │               └── transaction/
  |                   └── config/
  │                       └── CorsConfig.java
  │                   └── controllers/
  │                       └── TransactionController.java
  │                   └── model/
  │                       └── ParentTransaction.java
  │                       └── ParentTransactionDTO.java
  │                       └── ChildTransaction.java
  |                       └── ParentTransactionResponse.java
  │                   └── service/
  │                       └── IParentTransactionService.java
  |                       └── ParentTransactionServiceImpl.java
  |                       └── IChildTransactionService.java
  |                       └── ChildTransactionServiceImpl.java
  │               └── TransactionApplication.java
  └── pom.xml

parent-child-transaction-frontend/
  ├── public/
  │   └── index.html
  ├── src/
  │   ├── components/
  │   │   ├── ParentTransactionTable.js
  │   │   ├── ChildTransactionTable.js
  │   │   └── ChildTransaction.js
  |   |   └── ParentTransaction.js
  |   ├── style/
  |   |   └── ChildTransactionTable.css
  |   |   └── ParentTransactionTable.css
  │   ├── App.js
  │   ├── index.js
  └── package.json

README.md
```

### Demo

You can access the frontend of the Parent-Child Transaction Management System by visiting [http://localhost:3000](http://localhost:3000) after running the frontend server.

## Credits

- Developed by [janamgupta](https://github.com/janamgupta)

## License

This project is open-source and available under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code as per the terms of the license.

## Contributions

Contributions to the project are always welcome! If you find any issues or want to add new features, please create a pull request.

## Contact

For any questions or inquiries, please contact [janam.gupta.bgi@gmail.com](mailto:janam.gupta.bgi@gmail.com).

---
Happy coding!
