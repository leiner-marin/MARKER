# Traceability

This matrix connects MARKER business objectives to domain models, services, input ports, use cases, output ports, adapters, and tests.

| Objective | Capability | Domain | Domain Service | Input Port / Use Case | Output Port | Adapter / Integration | Test Focus |
|---|---|---|---|---|---|---|---|
| OBJ-01 | User management | User, UserRole, UserStatus | UserService, UserValidationService | RegisterUserUseCase, ManageUserUseCase / DefaultUserUseCase | UserRepositoryPort | User REST adapter, user repository adapter | Unique identifier, unique email, valid role, status |
| OBJ-02 | Seller management | Seller, SellerStatus | SellerService, SellerOnboardingService | OnboardSellerUseCase, ManageSellerUseCase | SellerRepositoryPort, NotificationPort | Seller use case and REST adapter | Seller onboarding and authorization |
| OBJ-03 | Buyer management | Buyer, CommercialStatus | BuyerService, BuyerAddressService | RegisterBuyerUseCase, ManageBuyerUseCase | BuyerRepositoryPort | Buyer use case and REST adapter | Buyer registration and address rules |
| OBJ-04 | Warehouse management | Warehouse, WarehouseType | WarehouseService, WarehouseAssignmentService | ManageWarehouseUseCase | WarehouseRepositoryPort | Warehouse use case and REST adapter | Warehouse registration and assignment |
| OBJ-05 | Product catalog | Product, ProductType, ProductStatus | ProductService, ProductVariantService, ProductPublicationService, CatalogService | RegisterProductUseCase, ManageProductUseCase, PublishProductUseCase | ProductRepositoryPort | Product REST and JPA adapters | Product registration, variants, publication |
| OBJ-06 | Inventory | Inventory, InventoryMovementType, Quantity | InventoryService, InventoryReservationService, InventoryMovementService, InventoryAdjustmentService | ManageInventoryUseCase, ReserveInventoryUseCase | InventoryRepositoryPort, InventoryMovementRepositoryPort | Inventory REST and JPA adapters | Non-negative stock, valid reservation, movements |
| OBJ-07 | Shopping cart | Cart, Product | CartService | ManageCartUseCase / DefaultCartUseCase | CartRepositoryPort | Cart REST and repository adapter | Add, remove, clear, unavailable products |
| OBJ-08 | Orders | Order, OrderStatus | OrderService, OrderValidationService, OrderStatusService, OrderPreparationService | CreateOrderUseCase, ManageOrderUseCase / DefaultOrderUseCase | OrderRepositoryPort, CartRepositoryPort, InventoryRepositoryPort | Order REST and repository adapter | Valid transitions and finalization |
| OBJ-09 | Payment and invoicing | Payment, Invoice, PaymentStatus | PaymentService, InvoiceService | ProcessPaymentUseCase, GenerateInvoiceUseCase | PaymentPort, InvoicePort, InvoiceRepositoryPort | Payment, invoice, REST adapters | Accepted/rejected payment and invoice creation |
| OBJ-10 | Shipment and delivery | Shipment, ShipmentStatus | ShipmentService, DeliveryService, Preparation/Dispatch services | ManageShipmentUseCase, ConfirmDeliveryUseCase | ShipmentRepositoryPort, LogisticsPort | Shipment REST and logistics adapters | Dispatch and delivery lifecycle |
| OBJ-11 | Returns and refunds | ReturnRequest, Refund, ReturnStatus, RefundStatus | ReturnService, RefundService | RequestReturnUseCase, ProcessRefundUseCase | ReturnRepositoryPort, RefundRepositoryPort, PaymentPort | Return/refund REST and integration adapters | Valid return and refund processing |
| OBJ-12 | Administrative reports | AdministrativeReport | AdministrativeReportService / reporting services | GenerateAdministrativeReportUseCase | ReportPort | Report adapter and REST controller | Report generation and authorization |

## Completion Rule

A capability is considered complete only when its requirement can be traced through:

`Requirement → Domain → Domain Service → Input Port → Use Case → Output Port → Adapter → Test`

The matrix must describe the real implementation. Names that do not exist in the code must not be listed as completed components.
