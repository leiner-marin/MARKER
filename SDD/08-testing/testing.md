# Testing Strategy

## Domain tests
Validate entities, value objects, domain services, business rules, state transitions, and domain exceptions without requiring Spring.

## Use case tests
Verify application orchestration by mocking output ports and external contracts.

## Adapter tests
Cover REST controllers, mappers, persistence adapters, JPA mapping, and security configuration.

## Integration tests
Verify Spring wiring, persistence, REST integration, and security behavior.

## Critical scenarios
- Duplicate user identity and email
- Invalid seller onboarding
- Negative inventory
- Excess inventory reservation
- Damaged inventory reservation
- Invalid order transitions
- Modification of finalized orders
- Unauthorized operations
- Invalid return and refund operations

## Completion
The complete Maven test suite must pass before final delivery.