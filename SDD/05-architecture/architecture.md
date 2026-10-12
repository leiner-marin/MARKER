# MARKER Architecture

MARKER uses DDD and Hexagonal Architecture.

## Dependency direction
Business Requirements → Domain → Input Ports → Use Cases → Output Ports → Adapters → Infrastructure

## Domain Core
The domain contains entities, enums, value objects, exceptions, domain services, input ports, and output ports.

The domain must not depend on Spring, JPA, REST, HTTP, or database-specific implementations.

## Use Cases
Use case implementations belong under application/adapters/useCases.
They orchestrate application flows and delegate business rules to domain services.

## REST Adapters
REST controllers, DTOs, mappers, validation, and exception handling belong under application/adapters/rest.

## Persistence
Persistence implementations stay outside the domain.

Domain Output Port → Persistence Adapter → JPA Repository → JPA Entity → Database

## Infrastructure
Infrastructure contains technical configuration, security, persistence wiring, and external integrations.