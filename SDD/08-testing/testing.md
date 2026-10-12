# Testing Strategy

## Domain Tests

Domain tests validate business rules without requiring Spring. Coverage includes User, Buyer, Seller, Product, Inventory, Cart, Order, Payment, Invoice, Shipment, Delivery, Returns, Refunds, publication lifecycle, inventory movements, and identity uniqueness.

## Application Tests

Application tests validate use case orchestration, repository integration, payment processing, inventory reservation, order lifecycle, and persistence invariants.

## Integration Tests

- Spring application context loading
- Authentication required for API
- Role-based API authorization
- Authenticated catalog access
- Docker Compose startup
- Authenticated REST smoke test
- Java 17 build verification

## Critical Scenarios

- Duplicate identity document
- Duplicate email
- Missing required identity data
- Seller onboarding
- Seller cannot self-register
- Product registration before publication
- Product publication, suspension, and discontinuation
- Product variants
- Physical versus digital product delivery
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
4. Role-based security tests.
5. Docker cleanup.
