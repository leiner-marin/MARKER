# Output Ports

## Purpose

Output ports isolate the domain and application use cases from persistence and external integrations.

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

## External Ports

- PaymentPort
- InvoicePort
- LogisticsPort
- NotificationPort
- ReportPort

## Rules

- Output ports live under application/domain/ports/out.
- Repository ports use the RepositoryPort suffix.
- External integrations use the Port suffix.
- Ports expose domain-oriented contracts only.
- Ports must not depend on Spring Data, JPA, SQL, HTTP, or other infrastructure implementations.
- Every output port must have an adapter implementation before the related use case is considered complete.
