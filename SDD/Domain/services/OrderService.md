# OrderService

## Purpose
Creates orders and validates order state transitions.

## Responsibilities
Prevents modification after finalization.

## Integration
Maintains the standard marketplace order lifecycle.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
