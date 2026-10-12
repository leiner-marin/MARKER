# Domain Exceptions

Domain exceptions represent business violations and invalid operations.

## Current Exceptions

- DomainViolationException
- InventoryValidationException
- ProductValidationException
- SellerValidationException

## Rule

Infrastructure exceptions must not leak into the domain. Domain services should use meaningful domain exceptions when a business rule is violated.
