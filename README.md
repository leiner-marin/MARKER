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

## Canonical source structure

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
    ├── persistence/
    ├── security/
    └── external/
```

## Principles
- The domain is independent from Spring, JPA, REST, HTTP, and database implementations.
- Input ports define application entry contracts.
- Output ports define persistence and external integration contracts.
- Use cases orchestrate application flows.
- Controllers remain thin and call input ports.
- Documentation and implementation must remain synchronized.

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

The project targets Java 17 and uses Maven-based automated validation.

## Status
MARKER is being consolidated into a single architecture aligned with DDD and Hexagonal Architecture. Existing valid functionality is preserved while duplicate contracts and responsibilities are removed.