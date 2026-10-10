# Input Ports

## Purpose
Input ports define the application use case contracts. They are the boundary through which REST adapters, tests, or other clients invoke MARKER behavior.

## Required Use Case Ports
- RegisterUserUseCase
- ManageUserUseCase
- RegisterBuyerUseCase
- OnboardSellerUseCase
- ManageSellerUseCase
- RegisterWarehouseUseCase
- ManageWarehouseUseCase
- RegisterProductUseCase
- PublishProductUseCase
- ManageInventoryUseCase
- ReserveInventoryUseCase
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
- Input ports must live under `application/domain/ports/in` until the project adopts a separate application layer package.
- Names must describe use cases, not actors.
- Input ports may depend on domain types or use case command/result objects, but never on JPA entities or REST DTOs.
- Every input port must have an implementation and tests.
