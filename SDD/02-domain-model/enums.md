# Domain Enums

## UserRole

- BUYER
- SELLER
- LOGISTICS_OPERATOR
- ADMINISTRATOR
- SUPERVISOR

## UserStatus

- ACTIVE
- INACTIVE
- BLOCKED

The business specification defines ACTIVE and BLOCKED. INACTIVE is retained as an implementation extension for explicit deactivation.

## ProductType

- PHYSICAL
- DIGITAL

## ProductStatus

Source-defined states:
- PUBLISHED
- SUSPENDED
- DISCONTINUED

Implementation extension:
- DRAFT — internal pre-publication state used while product information is being prepared.

## InventoryMovementType

- INGRESS
- RESERVE
- SALE_OUT
- ADJUSTMENT
- RETURN

## OrderStatus

Source-defined lifecycle:
- CART
- PENDING_PAYMENT
- PAID
- DISPATCHED
- DELIVERED
- FINALIZED

Implementation extensions:
- CREATED — internal initialization state retained for compatibility.
- CANCELLED — reserved for a future cancellation flow; not part of the source-defined lifecycle.
- RETURNED — reserved for return processing; return requests are now modeled separately.
- REFUNDED — reserved for refund processing; refunds are now modeled separately.

The application must use the source-defined lifecycle for the standard order flow.

## Additional Enums

- CommercialStatus
- SellerStatus
- WarehouseType
- PaymentStatus
- ShipmentStatus
- ReturnStatus
- RefundStatus
