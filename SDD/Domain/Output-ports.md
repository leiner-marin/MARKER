# Output Ports

## Purpose
Output ports isolate the domain and use cases from persistence, external systems, notifications, payment providers, logistics providers, and reports.

## Required Repository Ports
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

## Required External Ports
- PaymentPort
- InvoicePort
- LogisticsPort
- NotificationPort
- ReportPort

## Rules
- Output ports must live under `application/domain/ports/out`.
- Repository ports should be named with the `RepositoryPort` suffix.
- External-service ports should use the `Port` suffix.
- Output ports expose domain-oriented contracts, not database or framework details.
- Every output port must have at least one adapter implementation before its use case is considered complete.
