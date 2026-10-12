# Domain Model Classes

## User
- id: Long
- fullName: String
- email: String
- role: UserRole
- status: UserStatus

## Buyer
- primaryAddress: String
- additionalAddresses: List<String>
- commercialStatus: CommercialStatus

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
- shipmentStatus: ShipmentStatus
- dispatchDate: LocalDateTime
- deliveryDate: LocalDateTime

## Payment
- id: Long
- order: Order
- amount: BigDecimal
- paymentDate: LocalDateTime
- status: PaymentStatus
- method: String

## ReturnRequest
- id: Long
- order: Order
- product: Product
- reason: String
- requestDate: LocalDateTime
- status: String
- amount: BigDecimal

## Refund
- id: Long
- returnRequest: ReturnRequest
- amount: BigDecimal
- date: LocalDateTime
- status: String

## AdministrativeReport
- id: Long
- reportType: String
- generationDate: LocalDateTime
- data: String
