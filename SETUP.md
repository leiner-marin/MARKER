# MARKER Setup Guide

## Requirements

- JDK 17
- Git
- Maven Wrapper
- Docker and Docker Compose (optional)

## Local Setup

Open the repository root and run:

```powershell
.\mvnw.cmd clean verify
```

Start the application:

```powershell
.\mvnw.cmd spring-boot:run
```

## Docker

Build and start the environment:

```bash
docker compose up --build
```

Stop the environment:

```bash
docker compose down
```

## Environment Variables

- SPRING_PROFILES_ACTIVE
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_JPA_HIBERNATE_DDL_AUTO
- SPRING_H2_CONSOLE_ENABLED
- APP_SECURITY_USER
- APP_SECURITY_PASSWORD

## Architecture Rules

- Business rules remain inside the domain.
- JPA and database details remain outside the domain.
- Input ports define application entry contracts.
- Output ports define application exit contracts.
- Controllers remain thin.
- Avoid duplicate packages and responsibilities.
- Keep SDD documentation synchronized with implementation.

## Verification

The GitHub Actions workflow runs `clean verify` and builds the Docker image with Java 17.
