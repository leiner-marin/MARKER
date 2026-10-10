# MARKER Completion Roadmap

## Current Position
MARKER compiles and its existing tests pass, but the implementation is not functionally complete. The next work must reduce naming inconsistency, close the domain model, align documentation with Java contracts, and then implement use cases, adapters, persistence, security, and tests in order.

## Phase 1: Domain Cleanup
- Normalize all domain names to English.
- Remove duplicate Spanish/English service concepts.
- Keep domain entities free from Spring, JPA, and HTTP annotations.
- Separate Cart from Order and keep their lifecycle rules explicit.

## Phase 2: Enums, Value Objects, and Exceptions
- Finalize required enums and their values.
- Keep only value objects that enforce real invariants, such as Money and Quantity.
- Consolidate domain exceptions into meaningful business errors.

## Phase 3: Domain Services
- Compare every service document with its Java service.
- Remove undocumented Java methods or document them with business justification.
- Add missing Java methods that are documented and required.
- Keep services focused on business rules, not infrastructure.

## Phase 4: Ports
- Normalize input ports under `domain/ports/in`.
- Normalize output ports under `domain/ports/out`.
- Rename repository ports with the `RepositoryPort` suffix.
- Ensure every use case depends on ports, not concrete adapters.

## Phase 5: Use Cases
- Implement all input ports as application services.
- Use domain services for business rules.
- Use output ports for persistence and integrations.
- Add positive and negative use case tests.

## Phase 6: Persistence
- Implement JPA entities, repositories, mappers, and adapters.
- Keep JPA out of the domain model.
- Define relationships, constraints, indexes, enum mappings, and initial data.

## Phase 7: REST API
- Create REST controllers, DTOs, mappers, validation, and a global exception handler.
- Keep controllers thin and delegate to input ports.
- Do not expose JPA entities or domain internals directly.

## Phase 8: Security
- Implement authentication and authorization outside the domain.
- Enforce role restrictions at the adapter/application boundary.
- Ensure every protected operation requires an authenticated user.

## Phase 9: Test Completion
- Add coverage for User, Buyer, Seller, Warehouse, Product, Inventory, Cart, Order, Payment, Invoice, Shipment, Return, Refund, and Reports.
- Add negative tests for duplicate identifiers, negative stock, invalid reservations, unauthorized operations, invalid order transitions, finalized order mutation, and invalid seller registration.

## Phase 10: Repository Cleanup
- Remove temporary files, crash logs, debug output, generated files, installers, and unnecessary binaries.
- Keep README, SETUP, SDD, and code naming aligned.
- Run the full Maven test suite before every commit.
