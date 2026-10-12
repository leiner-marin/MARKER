# OrderService

## Purpose
Controls order creation and lifecycle transitions.

## Responsibilities
- Validate buyer and published products.
- Create new orders in CART state.
- Confirm cart-derived orders into PENDING_PAYMENT.
- Reject invalid lifecycle transitions.
- Reject every modification after FINALIZED.
- Identify whether an order requires physical delivery.
- Finalize paid digital-only orders.

## Integration
Used by order, payment, and shipment application use cases.

## Architecture
This is a pure domain service and does not depend on Spring, JPA, REST, HTTP, or database implementations.
