# Data Model

Persistence remains outside the domain layer.

## Technology

The project supports Spring Data JPA and MySQL. H2 is available for local development and automated tests.

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

Product and Inventory currently provide JPA persistence adapters. The remaining aggregates use output-port contracts with in-memory adapters in the current project version, preserving the hexagonal boundary without placing persistence annotations in the domain.

## Rule

No JPA annotation, repository implementation, database connection, or Spring persistence dependency may be placed in the domain package.
