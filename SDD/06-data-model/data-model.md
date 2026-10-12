# Data Model

Persistence remains outside the domain layer.

## Technology

The project uses Spring Data JPA and supports MySQL. H2 is available for local development.

## Canonical Persistence Structure

```text
application/adapters/persistence/jpa/
├── entities/
├── repositories/
├── mappers/
└── adapters/
```

## Mapping Flow

Domain Entity
    ↓
JPA Mapper
    ↓
JPA Entity
    ↓
Spring Data Repository
    ↓
Database

JPA annotations must remain outside the domain entities.

Product and Inventory already have canonical persistence adapters in the hexagonal structure. Remaining aggregates must follow the same pattern as their use cases are completed.
