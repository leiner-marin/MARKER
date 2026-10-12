# MARKER

MARKER is a Java and Spring Boot backend for a centralized marketplace platform.

## Architecture

```text
Functional Specification
        ↓
Business Rules
        ↓
Domain Core
        ↓
Input / Output Ports
        ↓
Use Cases
        ↓
Adapters
        ↓
Infrastructure
        ↓
Tests
```

## Canonical Source Structure

```text
src/main/java/application/
├── domain/
│   ├── entities/
│   ├── enums/
│   ├── valueobjects/
│   ├── exceptions/
│   ├── services/
│   └── ports/
│       ├── in/
│       └── out/
├── adapters/
│   ├── useCases/
│   ├── rest/
│   │   ├── controllers/
│   │   ├── dtos/
│   │   ├── mappers/
│   │   └── exception/
│   └── persistence/
└── infrastructure/
    ├── config/
    ├── security/
    └── external/
```

## Business Scope

MARKER covers user, buyer, seller, warehouse, product catalog, inventory, cart, order, payment, invoicing, shipment, delivery, return, refund, and administrative reporting flows.

## Architecture Rules

- The domain is independent from Spring, JPA, REST, HTTP, and database implementations.
- Input ports define application entry contracts.
- Output ports define persistence and external integration contracts.
- Use cases orchestrate application flows.
- Controllers remain thin and call input ports.
- Persistence and external integrations remain outside the domain.
- Documentation and implementation use consistent English terminology.

## Technology

- Java 17
- Maven Wrapper
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 for local development
- MySQL support
- Docker Compose
- Lombok

## Run

Windows:

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

Docker:

```bash
docker compose up --build
```

## Validation

GitHub Actions executes the Maven test suite with Java 17.

## Project Status

The repository structure, domain boundaries, application ports, use cases, REST adapters, persistence adapters, business documentation, traceability, and Java 17 CI validation have been consolidated.
