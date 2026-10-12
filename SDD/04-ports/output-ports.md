# Output Ports

Output ports isolate application and domain logic from persistence and external integrations.

## Repository Ports

- UserRepositoryPort
- BuyerRepositoryPort
- SellerRepositoryPort
- WarehouseRepositoryPort
- ProductRepositoryPort
- InventoryRepositoryPort
- InventoryMovementRepositoryPort
- CartRepositoryPort
- OrderRepositoryPort
- PaymentRepositoryPort
- InvoiceRepositoryPort
- ShipmentRepositoryPort
- ReturnRepositoryPort
- RefundRepositoryPort

## External Integration Ports

- PaymentPort
- InvoicePort
- LogisticsPort
- NotificationPort
- ReportPort

## Rules

Output ports belong to the domain boundary. Concrete Spring Data, JPA, HTTP, and vendor implementations remain in adapters or infrastructure.
