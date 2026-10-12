# ProductPublicationService

## Purpose
Controls Product publication lifecycle.

## Responsibilities
Publishes, suspends, and discontinues products according to business rules.

## Integration
Prevents publication of discontinued products.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
