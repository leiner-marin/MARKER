# CatalogService

## Purpose
Provides the business-level view of products that are eligible for marketplace publication.

## Responsibilities
- Accept a product collection.
- Return only products with PUBLISHED status.
- Keep catalog filtering independent from persistence.

## Architecture
This is a domain service and must not depend on Spring, JPA, REST, HTTP, or database implementations.
