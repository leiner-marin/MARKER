# InventoryMovementService

## Purpose
Applies inventory movement rules and records the movement state.

## Responsibilities
- Support INGRESS, RESERVE, SALE_OUT, ADJUSTMENT, and RETURN.
- Reject zero or negative movement quantities.
- Prevent negative available stock.
- Consume reserved quantity first when a SALE_OUT is applied.
- Maintain movement type and timestamp.

## Integration
Used by inventory and shipment flows; persistence of movement history is handled through InventoryMovementRepositoryPort.

## Architecture
This is a pure domain service and does not depend on Spring, JPA, REST, HTTP, or database implementations.
