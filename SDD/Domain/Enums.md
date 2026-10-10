# Enums

## Required Enums
The domain must keep enum names and values in English:

- Role
- UserStatus
- SellerStatus
- WarehouseType
- ProductType
- ProductStatus
- CommercialStatus
- InventoryMovementType
- OrderStatus
- PaymentStatus
- ShipmentStatus

## Required Inventory Movement Values
InventoryMovementType must support:

- ENTRY
- RESERVATION
- SALE_EXIT
- ADJUSTMENT
- RETURN

## Required Order Lifecycle
OrderStatus must support the business lifecycle:

```text
CART -> PENDING_PAYMENT -> PAID -> DISPATCHED -> DELIVERED -> FINALIZED
```

A finalized order is immutable.

## Usage Rules
Enums standardize operational states and must be used consistently across services, ports, adapters, persistence mappings, and tests.
