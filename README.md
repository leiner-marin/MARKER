# MARKER

MARKER is a backend for the NexusMarket marketplace. It is designed using domain-oriented architecture with a clear separation between business rules, use cases, adapters, and infrastructure.

## System Purpose

MARKER models a marketplace with:
- users (buyers and sellers)
- products, variants, and catalog
- inventory and warehouses
- shopping cart, orders, and payments
- invoicing, logistics, and deliveries
- returns and refunds
- administrative reports and validations

## Core Architecture

The solution follows this layering:

1. Functional specification and business rules
2. Domain model
3. Domain services
4. Ports (input/output boundaries)
5. Use cases (application services)
6. Persistence and REST adapters
7. Infrastructure and configuration
8. Tests and validation

This separation keeps the domain decoupled from Spring, JPA, HTTP, and other infrastructure technologies.

## Repository Structure

- `SDD/` — functional specification, business rules and traceability
- `src/main/java/application/domain/` — entities, enums, models, value objects, exceptions, domain services and ports
- `src/main/java/application/adapters/` — adapters, mappers and use case implementations
- `src/main/java/application/infrastructure/` — configuration, security, persistence and technical components
- `src/main/java/application/api/` — REST exposure
- `src/test/java/` — unit and integration tests

## Design Principles

- The domain does not depend on Spring, JPA or HTTP.
- Domain services encapsulate business rules and validations.
- Ports define explicit contracts between domain and infrastructure.
- Use cases orchestrate flows without mixing business logic with storage or HTTP concerns.
- Avoid duplicate services or layers with overlapping responsibilities.
- Keep documentation and implementation synchronized.

## Domain Organization

The domain layer contains:
- business entities
- enums for states and types
- value objects with their own validation
- business exceptions
- domain services with specific responsibilities
- input and output ports

Domain services are plain business classes (not Spring components) that receive inputs, return results, or throw domain exceptions.

## Adapters and Infrastructure

Infrastructure and adapters handle:
- persistence
- repositories and JPA entities/mappers
- DTOs, requests and responses
- REST controllers
- security and authentication
- system configuration

This ensures business logic remains isolated and reusable.

## Technologies

- Java (project target version configured in `pom.xml`)
- Maven (uses the Maven Wrapper)
- Spring Boot 4.1.1
- Spring Data JPA
- H2 for local development
- Docker Compose
- Lombok (annotation processing)

## Running the project

1. Clone the repository.
2. Build:

```bash
./mvnw clean install
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

4. Optionally start infrastructure with Docker:

```bash
docker-compose up --build
```

## Running tests

```bash
./mvnw test
```

## Project status

The repository structure emphasizes a clean domain layer, reduces duplication, and strengthens separation between business logic and infrastructure. Documentation is kept aligned with implementation.
