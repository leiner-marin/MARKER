# Input Ports

## Purpose

Input ports define application use case contracts. They are the boundary through which REST adapters, tests, or other clients invoke MARKER behavior.

## Canonical Ports

- RegisterUserUseCase
- ManageUserUseCase
- RegisterBuyerUseCase
- OnboardSellerUseCase
- ManageSellerUseCase
- ManageWarehouseUseCase
- RegisterProductUseCase
- ManageProductUseCase
- PublishProductUseCase
- ManageInventoryUseCase
- ManageCartUseCase
- CreateOrderUseCase
- ProcessPaymentUseCase
- ManageOrderUseCase
- GenerateInvoiceUseCase
- ManageShipmentUseCase
- ConfirmDeliveryUseCase
- RequestReturnUseCase
- ProcessRefundUseCase
- GenerateAdministrativeReportUseCase

## Rules

- Input ports live under application/domain/ports/in.
- Names describe use cases, not technical transport mechanisms.
- Input ports must not depend on JPA entities, REST DTOs, or infrastructure classes.
- Every implemented input port must have a corresponding use case implementation and tests.
- Use cases must delegate business rules to domain services instead of duplicating them.
