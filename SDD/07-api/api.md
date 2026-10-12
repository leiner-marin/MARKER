# REST API

REST exposes application use cases through HTTP.

## Request Flow

HTTP Request → DTO → Mapper → Input Port → Use Case → Domain Service → Output Port → Adapter → Response

## Security

All `/api/**` endpoints require authentication. Role restrictions are applied at the REST boundary.

## Endpoints

| Area | Method | Endpoint | Purpose |
|---|---|---|---|
| Users | POST | /api/users | Register user |
| Users | GET | /api/users/{id} | Find user |
| Users | PUT | /api/users/{id} | Update user |
| Buyers | POST | /api/buyers | Register buyer |
| Buyers | GET | /api/buyers/{id} | Find buyer |
| Buyers | PUT | /api/buyers/{id} | Update buyer |
| Buyers | POST | /api/buyers/{id}/addresses | Add additional address |
| Sellers | POST | /api/sellers | Onboard seller |
| Sellers | GET | /api/sellers/{id} | Find seller |
| Sellers | PUT | /api/sellers/{id} | Update seller |
| Sellers | POST | /api/sellers/assign-warehouse | Assign warehouse |
| Warehouses | POST | /api/warehouses | Register warehouse |
| Warehouses | POST | /api/warehouses/classify | Classify warehouse |
| Products | GET | /api/products | List products |
| Products | POST | /api/products | Register product |
| Products | POST | /api/products/{id}/publish | Publish product |
| Products | POST | /api/products/{id}/suspend | Suspend product |
| Products | POST | /api/products/{id}/discontinue | Discontinue product |
| Products | POST | /api/products/{id}/variants | Add product variant |
| Catalog | GET | /api/catalog | List published products |
| Inventory | GET | /api/inventory/{productId} | Find inventory |
| Inventory | POST | /api/inventory | Register inventory |
| Inventory | POST | /api/inventory/{inventoryId}/reserve | Reserve stock |
| Inventory | POST | /api/inventory/{inventoryId}/movement | Apply inventory movement |
| Cart | POST | /api/carts/items | Add product |
| Cart | DELETE | /api/carts/items | Remove product |
| Cart | DELETE | /api/carts | Clear cart |
| Orders | POST | /api/orders | Create order |
| Orders | POST | /api/orders/from-cart | Create order from the buyer cart |
| Orders | GET | /api/orders/{id} | Find order |
| Orders | PUT | /api/orders/{id}/status | Advance order lifecycle |
| Payments | POST | /api/payments | Process payment |
| Invoices | POST | /api/invoices | Generate invoice |
| Shipments | POST | /api/shipments | Create shipment |
| Shipments | GET | /api/shipments/{id} | Find shipment |
| Shipments | PUT | /api/shipments/{id}/dispatch | Dispatch shipment |
| Shipments | PUT | /api/shipments/{id}/deliver | Confirm delivery |
| Returns | POST | /api/returns | Request return |
| Refunds | POST | /api/refunds | Process refund |
| Reports | GET | /api/reports?type=... | Generate administrative report |

Controllers remain thin and delegate to input ports. Business validation remains inside the domain.
