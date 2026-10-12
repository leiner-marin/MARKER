# Domain Exceptions

Domain exceptions represent business rule violations.

## Current exceptions

- DomainViolationException
- InventoryValidationException
- ProductValidationException
- SellerValidationException

Infrastructure-specific exceptions must not leak into the domain.
