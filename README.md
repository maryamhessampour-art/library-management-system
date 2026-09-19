# Library Management System

A Java-based library management system built with Spring Boot, focusing on object-oriented programming, borrowing logic, and organizing different types of library items.

## Features

- Object-oriented design using inheritance, interfaces, and polymorphism
- Support for books, magazines, DVDs, and reference materials
- Borrowing and returning library items
- Availability tracking
- Late return penalty calculation
- Add, delete, search, and sort library items
- DTO-based API requests
- Builder pattern for object creation
- Custom exception handling
- File-based data storage
- REST API using Spring Boot

## Technologies

- Java
- Spring Boot
- Maven
- Lombok
- REST API
- Postman
- Git & GitHub

## Project Structure

```text
LibraryManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── .../
│   │   │       ├── Controller/
│   │   │       ├── DTO/
│   │   │       ├── Service/
│   │   │       ├── builder/
│   │   │       ├── enums/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── storage/
│   │   └── resources/
│   └── test/
├── library.txt
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Main Components

### Library Items

The system supports different types of library items:

- `Book` — Represents books with borrowing rules and ISBN validation.
- `Magazine` — Represents magazines with their own borrowing period and penalty rules.
- `DVD` — Represents DVDs with information such as director and duration.
- `ReferenceMaterial` — Represents reference materials that require librarian assistance and cannot be borrowed.

### Object-Oriented Design

The project demonstrates several object-oriented programming concepts:

- **Inheritance** — Different library item types inherit common properties and behavior.
- **Interfaces** — The `Borrowable` interface defines borrowing-related behavior.
- **Polymorphism** — Different library items implement shared behavior according to their own rules.
- **Encapsulation** — Object state is controlled through class methods and access modifiers.
- **Abstraction** — Common library item behavior is defined in the abstract `LibraryItem` class.

### Design Patterns

- **Builder Pattern** — Used to create library item objects in a structured way.
- **DTO Pattern** — Used to transfer data between API requests and the application.

## API Endpoints

The application provides REST API endpoints for managing library items.

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/items` | Add a new library item |
| `GET` | `/api/items` | Get all library items |
| `GET` | `/api/items/{id}` | Get a library item by ID |
| `DELETE` | `/api/items/{id}` | Delete a library item |
| `POST` | `/api/items/{id}/borrow` | Borrow a library item |
| `POST` | `/api/items/{id}/return` | Return a library item |

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/maryamhessampour-art/library-management-system.git
cd library-management-system
```

### 2. Build the project

Using Maven Wrapper:

```bash
./mvnw clean install
```

### 3. Run the application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

### 4. Test the API

You can use Postman or another API client to send requests to the REST API endpoints.

## Data Storage

The application uses file-based storage to persist library item data.

Library data is stored in:

```text
library.txt
```

## Notes

- The project uses an in-memory repository together with file-based persistence.
- Postman can be used to test the REST API.
- The project was developed as a practical exercise in Java, OOP, and Spring Boot.
