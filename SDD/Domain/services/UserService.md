# UserService

## Purpose
Creates and manages the core User business object.

## Responsibilities
- Validate required identity data.
- Require exactly one valid role.
- Initialize the ACTIVE status when a status is not supplied.

## Integration
Used by RegisterUserUseCase and ManageUserUseCase after technical authentication has been handled at the infrastructure boundary.

## Architecture
This is a pure domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
