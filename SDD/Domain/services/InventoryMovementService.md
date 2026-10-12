# InventoryMovementService

## Purpose
Applies inventory movement rules.

## Responsibilities
Supports INGRESS, RESERVE, SALE_OUT, ADJUSTMENT, and RETURN.

## Integration
Delegates quantity validation to inventory domain services.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
