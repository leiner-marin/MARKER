# MARKER Setup Guide

## Requirements
- JDK 17
- Git
- Maven Wrapper
- Docker and Docker Compose (optional)

## Architecture
Specification → Domain → Ports → Use Cases → Adapters → Infrastructure → Tests

## Local setup
```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

## Docker
```bash
docker compose up --build
docker compose down
```

## Environment variables
- SPRING_PROFILES_ACTIVE
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- JWT_SECRET

## Development rules
- Keep business rules inside the domain.
- Keep JPA and database details outside the domain.
- Use input ports as application entry contracts.
- Use output ports as application exit contracts.
- Keep controllers thin.
- Avoid duplicate packages and responsibilities.
- Keep SDD documentation synchronized with the implementation.
