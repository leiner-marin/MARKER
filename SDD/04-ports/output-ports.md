# Output Ports

Output ports isolate domain and application logic from persistence and external integrations.

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
- InvoiceRepositoryPort
- ShipmentRepositoryPort
- ReturnRepositoryPort
- RefundRepositoryPort
- PaymentRepositoryPort

## Integration Ports

- PaymentPort
- InvoicePort
- LogisticsPort
- NotificationPort
- ReportPort

## Rules

- Output ports belong to the domain boundary.
- Repository ports use the RepositoryPort suffix.
- External integrations use the Port suffix.
- Ports expose domain-oriented contracts and remain independent from Spring Data, JPA, SQL, HTTP, and vendor-specific implementations.
