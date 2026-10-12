# Domain Services

## Purpose

Domain services encapsulate business logic that does not belong exclusively to a single domain entity.

## Current Services

- UserService
- UserValidationService
- BuyerService
- BuyerAddressService
- SellerService
- SellerOnboardingService
- WarehouseService
- WarehouseAssignmentService
- ProductService
- ProductPublicationService
- ProductVariantService
- CatalogService
- InventoryService
- InventoryReservationService
- InventoryMovementService
- InventoryAdjustmentService
- CartService
- OrderService
- OrderStatusService
- OrderValidationService
- PaymentService
- InvoiceService
- OrderPreparationService
- ShipmentService
- DeliveryService
- ReturnService
- RefundService
- AdministrativeReportService

Legacy Spanish-named service classes are being progressively replaced by canonical English application contracts without changing MARKER business requirements.

## Rule

Each domain service must validate preconditions, business rules, invalid states, and domain errors before completing its operation.
