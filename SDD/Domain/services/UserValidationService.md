# UserValidationService

## Purpose
Validates User business invariants.

## Responsibilities
Rejects null users, missing names, missing emails, and missing roles.

## Integration
Contains domain validation only; no infrastructure dependencies.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
