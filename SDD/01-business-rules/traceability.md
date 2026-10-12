# MARKER Traceability

This matrix connects MARKER objectives to domain models, services, input ports, use cases, output ports, adapters, and tests.

| Objective | Capability | Domain | Service | Input Port / Use Case | Output Port | Adapter | Test Focus |
|---|---|---|---|---|---|---|---|
| OBJ-01 | User management | User, UserRole, UserStatus | UserService, UserValidationService | RegisterUserUseCase, ManageUserUseCase | UserRepositoryPort | User REST and persistence adapters | Unique identity, unique email, valid role and status |
| OBJ-02 | Seller management | Seller, SellerStatus | SellerService, SellerOnboardingService | OnboardSellerUseCase, ManageSellerUseCase | SellerRepositoryPort, NotificationPort | Seller adapters | Seller onboarding and authorization |
| OBJ-03 | Buyer management | Buyer, CommercialStatus | BuyerService, BuyerAddressService | RegisterBuyerUseCase, ManageBuyerUseCase | BuyerRepositoryPort, UserRepositoryPort | Buyer adapters | Buyer registration and address rules |
| OBJ-04 | Warehouse management | Warehouse, WarehouseType | WarehouseService, WarehouseAssignmentService | ManageWarehouseUseCase | WarehouseRepositoryPort | Warehouse adapters | Registration and assignment |
| OBJ-05 | Product catalog | Product, ProductType, ProductStatus | ProductService, ProductVariantService, ProductPublicationService, CatalogService | RegisterProductUseCase, ManageProductUseCase, PublishProductUseCase, QueryCatalogUseCase | ProductRepositoryPort | Product REST and JPA adapters | Registration, variants, publication and catalog |
| OBJ-06 | Inventory | Inventory, InventoryMovementType, Quantity | InventoryService, InventoryReservationService, InventoryMovementService, InventoryAdjustmentService | ManageInventoryUseCase, ReserveInventoryUseCase | InventoryRepositoryPort, InventoryMovementRepositoryPort | Inventory REST and JPA adapters | Non-negative stock, damaged stock, reservations and movements |
| OBJ-07 | Shopping cart | Cart, Product | CartService | ManageCartUseCase | CartRepositoryPort | Cart REST and repository adapter | Add, remove, clear |
| OBJ-08 | Orders | Order, OrderStatus | OrderService, OrderValidationService, OrderStatusService, OrderPreparationService | CreateOrderUseCase, ManageOrderUseCase | OrderRepositoryPort, InventoryRepositoryPort | Order REST and repository adapter | Valid lifecycle and finalization |
| OBJ-09 | Payment and invoicing | Payment, Invoice, PaymentStatus | PaymentService, InvoiceService | ProcessPaymentUseCase, GenerateInvoiceUseCase | PaymentPort, PaymentRepositoryPort, InvoicePort, InvoiceRepositoryPort | Payment and invoice adapters | Accepted/rejected payment and paid-order invoice |
| OBJ-10 | Shipment and delivery | Shipment, ShipmentStatus | ShipmentService, DeliveryService, OrderPreparationService | ManageShipmentUseCase, ConfirmDeliveryUseCase | ShipmentRepositoryPort, LogisticsPort, OrderRepositoryPort | Shipment and logistics adapters | Dispatch, delivery and finalization |
| OBJ-11 | Returns and refunds | ReturnRequest, Refund, ReturnStatus, RefundStatus | ReturnService, RefundService | RequestReturnUseCase, ProcessRefundUseCase | ReturnRepositoryPort, RefundRepositoryPort | Return/refund adapters | Valid return and refund processing |
| OBJ-12 | Administrative reporting | Reporting contract | AdministrativeReportService | GenerateAdministrativeReportUseCase | ReportPort | Report adapter and REST controller | Supported report types and authorization |

## Traceability Rule

Each objective is considered implemented only when the flow can be followed through:

`Requirement → Domain → Service → Input Port → Use Case → Output Port → Adapter → Test`

This matrix must remain synchronized with the actual repository.
