# Input Ports

Input ports define the application use case contracts exposed by MARKER.

## Contracts

- RegisterUserUseCase
- ManageUserUseCase
- RegisterBuyerUseCase
- ManageBuyerUseCase
- OnboardSellerUseCase
- ManageSellerUseCase
- ManageWarehouseUseCase
- RegisterProductUseCase
- ManageProductUseCase
- PublishProductUseCase
- QueryCatalogUseCase
- ManageInventoryUseCase
- ReserveInventoryUseCase
- ManageCartUseCase
- CreateOrderUseCase
- ManageOrderUseCase
- ProcessPaymentUseCase
- GenerateInvoiceUseCase
- ManageShipmentUseCase
- ConfirmDeliveryUseCase
- RequestReturnUseCase
- ProcessRefundUseCase
- GenerateAdministrativeReportUseCase

## Rules

Input ports remain independent from REST, JPA, Spring, and infrastructure. Application use case implementations reside under `application/adapters/useCases`.
