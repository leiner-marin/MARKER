# UserService

## Purpose
Creates and manages the core User business object.

## Responsibilities
Validates required identity data and initializes role/status defaults.

## Integration
Used by RegisterUser and ManageUser application use cases.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
