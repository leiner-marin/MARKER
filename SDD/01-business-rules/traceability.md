# MARKER Traceability

This matrix connects MARKER business objectives to domain models, domain services, input ports, use cases, output ports, adapters, and tests.

| Objective | Capability | Domain | Service | Input Port / Use Case | Output Port | Adapter | Test Focus |
|---|---|---|---|---|---|---|---|
| OBJ-01 | User management | User, UserRole, UserStatus | UserService, UserValidationService | RegisterUserUseCase, ManageUserUseCase | UserRepositoryPort | User REST and persistence adapters | Unique identity, unique email, valid role and status |
| OBJ-02 | Seller management | Seller, SellerStatus | SellerService, SellerOnboardingService | OnboardSellerUseCase, ManageSellerUseCase | SellerRepositoryPort, NotificationPort | Seller adapters | Seller onboarding and authorization |
| OBJ-03 | Buyer management | Buyer, CommercialStatus | BuyerService, BuyerAddressService | RegisterBuyerUseCase, ManageBuyerUseCase | BuyerRepositoryPort | Buyer adapters | Buyer registration and address rules |
| OBJ-04 | Warehouse management | Warehouse, WarehouseType | WarehouseService, WarehouseAssignmentService | ManageWarehouseUseCase | WarehouseRepositoryPort | Warehouse adapters | Registration and assignment |
| OBJ-05 | Product catalog | Product, ProductType, ProductStatus | ProductService, ProductVariantService, ProductPublicationService, CatalogService | RegisterProductUseCase, ManageProductUseCase, PublishProductUseCase | ProductRepositoryPort | Product REST and JPA adapters | Registration, variants and publication |
| OBJ-06 | Inventory | Inventory, InventoryMovementType, Quantity | InventoryService, InventoryReservationService, InventoryMovementService, InventoryAdjustmentService | ManageInventoryUseCase, ReserveInventoryUseCase | InventoryRepositoryPort, InventoryMovementRepositoryPort | Inventory REST and JPA adapters | Non-negative stock and valid reservations |
| OBJ-07 | Shopping cart | Cart, Product | CartService | ManageCartUseCase | CartRepositoryPort | Cart REST and repository adapter | Add, remove and clear |
| OBJ-08 | Orders | Order, OrderStatus | OrderService, OrderValidationService, OrderStatusService, OrderPreparationService | CreateOrderUseCase, ManageOrderUseCase | OrderRepositoryPort, InventoryRepositoryPort | Order REST and repository adapter | Valid lifecycle and finalization |
| OBJ-09 | Payment and invoicing | Payment, Invoice, PaymentStatus | PaymentService, InvoiceService | ProcessPaymentUseCase, GenerateInvoiceUseCase | PaymentPort, InvoicePort, InvoiceRepositoryPort | Payment and invoice adapters | Payment and invoice rules |
| OBJ-10 | Logistics | Shipment, ShipmentStatus | ShipmentService, DeliveryService | ManageShipmentUseCase, ConfirmDeliveryUseCase | ShipmentRepositoryPort, LogisticsPort | Shipment and logistics adapters | Dispatch and delivery |
| OBJ-11 | Returns and refunds | ReturnRequest, Refund | ReturnService, RefundService | RequestReturnUseCase, ProcessRefundUseCase | ReturnRepositoryPort, RefundRepositoryPort | Return and refund adapters | Return and refund rules |
| OBJ-12 | Administrative reporting | AdministrativeReport | AdministrativeReportService | GenerateAdministrativeReportUseCase | ReportPort | Report REST and reporting adapter | Report generation and authorization |

## Traceability Rule

Each objective is considered implemented only when it can be followed through:

`Requirement → Domain → Service → Input Port → Use Case → Output Port → Adapter → Test`

This matrix must remain synchronized with the actual repository.
