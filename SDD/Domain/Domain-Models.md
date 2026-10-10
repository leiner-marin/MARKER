# Domain Models

## Core Entities
MARKER must normalize the domain around these English-named core entities:

- User
- Buyer
- Seller
- Warehouse
- Product
- Inventory
- Cart
- Order
- Payment
- Invoice
- Shipment
- Return
- Refund
- AdministrativeReport

## Supporting Domain Concepts
The domain may also use supporting concepts when they clarify business rules without leaking infrastructure concerns:

- ProductVariant
- InventoryMovement
- Address
- Delivery
- Money
- Quantity

## Modeling Rules
- Domain classes must use English names only.
- Domain entities must not depend on Spring, JPA, HTTP, or database annotations.
- Persistence entities belong in infrastructure adapters, not in the domain package.
- Cart and Order are independent concepts: a cart is provisional, while an order is a commercial commitment.
- Inventory must enforce non-negative stock and must record coherent movements for entries, reservations, sale exits, adjustments, and returns.
- A finalized order cannot be modified.
