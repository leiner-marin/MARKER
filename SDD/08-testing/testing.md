# Testing Strategy

## Domain Tests

Domain tests validate business rules without requiring Spring. Current coverage includes user, buyer, product, inventory, cart, order, payment, invoice, shipment/delivery, seller, returns/refunds, publication lifecycle, and inventory movements.

## Application and Integration Tests

- Spring application context loading
- Security configuration
- Maven compilation and test execution
- Docker Compose startup
- Authenticated REST smoke test

## Critical Scenarios

- Duplicate user email
- Missing required identity data
- Seller onboarding
- Product publication and suspension
- Product variants
- Negative inventory
- Damaged inventory reservation
- Excess inventory reservation
- Inventory movement traceability
- Invalid order transitions
- Finalized order mutation
- Paid-order invoicing
- Shipment dispatch and delivery
- Payment acceptance and failure
- Return and refund processing

## CI Gate

GitHub Actions must pass:

1. `clean verify` with Java 17.
2. Docker Compose build and startup.
3. Authenticated API smoke test.
4. Docker cleanup.
