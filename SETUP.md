# Project setup

## Requirements
- Java 17 or higher (use JDK 21 for LTS compatibility where appropriate)
- Maven Wrapper (included)
- Docker and Docker Compose (optional)
- Git

## Target structure

MARKER keeps a clear separation between layers:

```text
Specification -> Domain -> Ports -> Use Cases -> Adapters -> Infrastructure -> Tests
```

Business logic lives in `src/main/java/application/domain`, while infrastructure, persistence and REST endpoints are isolated under `application/adapters`, `application/infrastructure` and `application/api`.

## Local setup

1. Open the project root.
2. Build:

```bash
./mvnw clean install
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

## Docker

```bash
docker-compose up --build
```

## Recommended environment variables

- `SPRING_PROFILES_ACTIVE`
- `DB_URL` / `DB_USERNAME` / `DB_PASSWORD`
- `SPRING_DATASOURCE_URL` / `SPRING_DATASOURCE_USERNAME` / `SPRING_DATASOURCE_PASSWORD`

## Verification

- confirm the application starts without errors
- check logs and active endpoints
- run tests:

```bash
./mvnw test
```

## Development rules

- do not mix business logic with controllers, repositories or JPA
- keep domain services decoupled from infrastructure
- use ports to abstract persistence and external services
- ensure single responsibility per component
- avoid duplication between `domain/services` and `application/services`
- keep `SDD/` synchronized with the implementation
