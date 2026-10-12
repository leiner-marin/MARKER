# ProductVariantService

## Purpose
Manages product variant information.

## Responsibilities
- Add non-empty variants.
- Avoid duplicate variants.
- Keep variant rules inside the domain.

## Architecture
This is a domain service and must not depend on Spring, JPA, REST, HTTP, or database implementations.
