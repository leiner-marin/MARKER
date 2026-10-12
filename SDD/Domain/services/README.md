# MARKER Domain Services

Every domain service listed here has one Markdown specification and one Java implementation under:

`src/main/java/application/domain/services/`

## Service Catalog

1. UserService
2. UserValidationService
3. BuyerService
4. BuyerAddressService
5. SellerService
6. SellerOnboardingService
7. WarehouseService
8. WarehouseAssignmentService
9. ProductService
10. ProductPublicationService
11. ProductVariantService
12. CatalogService
13. InventoryService
14. InventoryReservationService
15. InventoryMovementService
16. InventoryAdjustmentService
17. CartService
18. OrderService
19. OrderStatusService
20. OrderValidationService
21. OrderPreparationService
22. PaymentService
23. InvoiceService
24. ShipmentService
25. DeliveryService
26. ReturnService
27. RefundService
28. AdministrativeReportService

## Traceability Rule

`SDD/Domain/services/<ServiceName>.md` ↔ `src/main/java/application/domain/services/<ServiceName>.java`

The documentation describes the business responsibility and the Java class contains the corresponding domain behavior.

## Boundary Rule

Domain services must not import Spring, JPA, REST, HTTP, database drivers, or other infrastructure technologies.
