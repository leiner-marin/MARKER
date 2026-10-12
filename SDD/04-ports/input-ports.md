# Input Ports

Input ports define the application use case contracts exposed by MARKER.

## Current Contracts

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

- Input ports belong to the domain boundary.
- They do not depend on REST DTOs, JPA entities, Spring components, or infrastructure.
- Each implemented application flow should be accessible through an explicit input contract.
