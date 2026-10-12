# OrderValidationService

## Purpose
Validates order preconditions.

## Responsibilities
Requires a valid buyer and at least one product.

## Integration
Prevents invalid orders from entering the application flow.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
