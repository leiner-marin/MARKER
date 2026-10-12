# ProductService

## Purpose
Creates and validates Product business data.

## Responsibilities
Requires name, seller, and product type.

## Integration
Keeps product rules independent from persistence.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
