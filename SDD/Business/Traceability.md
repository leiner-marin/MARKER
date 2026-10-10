# Traceability

## Purpose
This document links MARKER business objectives to the domain model, domain services, ports, use cases, adapters, and tests that must support each objective.

## Traceability Matrix

| Objective | Requirement | Domain Model | Domain Service | Input Port / Use Case | Output Port | Adapter | Tests |
| --- | --- | --- | --- | --- | --- | --- | --- |
| OBJ-01 | Register and manage users | User, Role, UserStatus | UserService, UserValidationService | RegisterUserUseCase, ManageUserUseCase | UserRepositoryPort, NotificationPort | REST user controller, JPA user adapter | User registration, duplicate email, invalid role, status changes |
| OBJ-02 | Register and manage buyers | Buyer, User | BuyerService | RegisterBuyerUseCase | BuyerRepositoryPort, UserRepositoryPort | REST buyer controller, JPA buyer adapter | Buyer registration, invalid linked user, duplicate identity |
| OBJ-03 | Onboard and manage sellers | Seller, SellerStatus, User | SellerService, SellerOnboardingService | OnboardSellerUseCase, ManageSellerUseCase | SellerRepositoryPort, UserRepositoryPort, NotificationPort | REST seller controller, JPA seller adapter | Seller onboarding, invalid seller registration, status transitions |
| OBJ-04 | Register and administer warehouses | Warehouse, WarehouseType | WarehouseService, WarehouseAssignmentService | RegisterWarehouseUseCase, ManageWarehouseUseCase | WarehouseRepositoryPort | REST warehouse controller, JPA warehouse adapter | Warehouse registration, invalid capacity, duplicate warehouse |
| OBJ-05 | Register, classify, and publish products | Product, ProductType, ProductStatus | ProductService, ProductVariantService, ProductPublicationService | RegisterProductUseCase, PublishProductUseCase | ProductRepositoryPort, SellerRepositoryPort | REST product controller, JPA product adapter | Product registration, invalid seller, invalid publication state |
| OBJ-06 | Manage inventory and stock reservations | Inventory, InventoryMovement, Quantity | InventoryService, InventoryReservationService, InventoryMovementService, InventoryAdjustmentService | ManageInventoryUseCase, ReserveInventoryUseCase | InventoryRepositoryPort, InventoryMovementRepositoryPort, ProductRepositoryPort | REST inventory controller, JPA inventory adapter | Negative stock, invalid reservation, missing inventory, damaged stock |
| OBJ-07 | Manage cart before checkout | Cart, Product, Inventory | CartService | ManageCartUseCase | CartRepositoryPort, ProductRepositoryPort, InventoryRepositoryPort | REST cart controller, JPA cart adapter | Add item, remove item, invalid quantity, unavailable product |
| OBJ-08 | Create and manage orders | Order, OrderStatus, Cart | OrderService, OrderValidationService, OrderStatusService, OrderPreparationService | CreateOrderUseCase, ManageOrderUseCase | OrderRepositoryPort, CartRepositoryPort, InventoryRepositoryPort | REST order controller, JPA order adapter | Order creation, invalid transition, finalized order cannot be modified |
| OBJ-09 | Process payments and generate invoices | Payment, PaymentStatus, Invoice, Money | PaymentService, InvoiceService | ProcessPaymentUseCase, GenerateInvoiceUseCase | PaymentPort, InvoicePort, OrderRepositoryPort | Payment adapter, invoice adapter, REST payment controller | Payment accepted, payment rejected, invoice generated once |
| OBJ-10 | Manage shipment and delivery | Shipment, ShipmentStatus, Order | ShipmentService, DispatchService, DeliveryService, LogisticsService | ManageShipmentUseCase, ConfirmDeliveryUseCase | ShipmentRepositoryPort, LogisticsPort, OrderRepositoryPort | Logistics adapter, REST shipment controller, JPA shipment adapter | Dispatch, delivery confirmation, invalid shipment state |
| OBJ-11 | Manage returns and refunds | Return, Refund, Order, Payment | ReturnService, RefundService | RequestReturnUseCase, ProcessRefundUseCase | ReturnRepositoryPort, RefundRepositoryPort, PaymentPort, OrderRepositoryPort | REST return/refund controllers, JPA adapters, payment adapter | Valid return, invalid return window, refund processed once |
| OBJ-12 | Generate administrative reports | AdministrativeReport | AdministrativeReportService | GenerateAdministrativeReportUseCase | ReportPort, OrderRepositoryPort, PaymentPort, InventoryRepositoryPort | Report adapter, REST report controller | Sales report, inventory report, authorization rules |

## Completion Rule
Every business feature must be traceable through this path:

```text
Requirement -> Domain Model -> Domain Service -> Input Port -> Use Case -> Output Port -> Adapter -> Test
```

A feature is not considered complete until every element in that path exists, is named consistently in English, and is covered by positive and negative tests.
