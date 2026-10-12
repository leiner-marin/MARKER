# ProductService

## Purpose
Creates and validates product business data.

## Responsibilities
- Require a product name.
- Require an associated seller.
- Require a valid product type.
- Assign SUSPENDED as the initial catalog state when no state was supplied, keeping registration separate from publication.

## Integration
Used by the product registration use case. Publication is handled separately by ProductPublicationService.

## Architecture
This is a pure domain service and does not depend on Spring, JPA, REST, HTTP, or database implementations.
