# MARKER Completion Status

## Completed

### Domain Core
- Domain entities are organized under `application/domain/entities`.
- Enums, value objects, and domain exceptions are separated.
- Cart is modeled independently from Order.
- Domain services are free from Spring and infrastructure dependencies.

### Ports
- Input ports are under `application/domain/ports/in`.
- Output ports are under `application/domain/ports/out`.
- Repository contracts use the `RepositoryPort` suffix.

### Application
- Use case implementations are under `application/adapters/useCases`.
- Use cases coordinate domain services and output ports.

### REST
- Controllers are under `application/adapters/rest/controllers`.
- DTOs and mappers are separated where boundary mapping is required.
- Global REST exception handling is available.

### Persistence
- JPA entities, repositories, mappers, and adapters are isolated from the domain.
- In-memory adapters remain available for lightweight application execution and tests.

### Documentation
- Business requirements, business rules, domain documentation, use cases, architecture, API, testing, and traceability documentation are maintained in English.
- Each canonical domain service has a matching Markdown document.

### Quality
- The project targets Java 17.
- GitHub Actions validates the Maven test suite.
- Generated logs, crash reports, executables, and temporary outputs are ignored and removed from the repository.

## Final Acceptance Gate

1. `clean test` passes.
2. The Spring Boot project compiles successfully.
3. The documented architecture matches the repository structure.
4. No duplicate legacy service or port directories remain.
5. Business objectives are traceable to application components and tests.
