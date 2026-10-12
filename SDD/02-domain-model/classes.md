# Domain Model Classes

## User
- id: Long
- identityDocument: String
- fullName: String
- email: String
- role: UserRole
- status: UserStatus

## Buyer
- primaryAddress: String
- additionalAddresses: List<String>
- commercialStatus: CommercialStatus
- activeCart: boolean
- orderHistory: List<Order>

## Seller
- associatedWarehouses: List<Warehouse>
- productCatalog: List<Product>
- incorporationDate: LocalDate
- sellerStatus: SellerStatus

## Warehouse
- id: Long
- name: String
- location: String
- type: WarehouseType
- ownerSeller: Seller

## Product
- id: Long
- name: String
- productType: ProductType
- variants: List<String>
- status: ProductStatus
- seller: Seller

## Inventory
- id: Long
- product: Product
- warehouse: Warehouse
- availableQuantity: Integer
- reservedQuantity: Integer
- damaged: boolean
- movementType: String
- movementDate: LocalDateTime

## Cart
- id: Long
- buyer: Buyer
- products: List<Product>

## Order
- id: Long
- buyer: Buyer
- products: List<Product>
- status: OrderStatus
- creationDate: LocalDateTime
- updateDate: LocalDateTime

## Payment
- id: Long
- order: Order
- amount: BigDecimal
- paymentDate: LocalDateTime
- status: PaymentStatus
- method: String

## Invoice
- id: Long
- order: Order
- amount: BigDecimal
- issueDate: LocalDateTime
- paymentStatus: PaymentStatus

## Shipment
- id: Long
- order: Order
- originWarehouse: Warehouse
- deliveryAddress: String
- trackingNumber: String
- shipmentStatus: ShipmentStatus
- dispatchDate: LocalDateTime
- deliveryDate: LocalDateTime

## ReturnRequest
- id: Long
- order: Order
- product: Product
- reason: String
- requestDate: LocalDateTime
- status: ReturnStatus
- amount: BigDecimal

## Refund
- id: Long
- returnRequest: ReturnRequest
- amount: BigDecimal
- date: LocalDateTime
- status: RefundStatus

Administrative reporting is exposed through the reporting use case and does not require a dedicated persistence entity in the current implementation.
