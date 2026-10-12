# Domain Relationships

## Main Relationships

- Buyer → Cart
- Buyer → Order
- Seller → Product
- Seller → Warehouse
- Product → Inventory
- Warehouse → Inventory
- Order → Payment
- Order → Invoice
- Order → Shipment
- Order → ReturnRequest
- ReturnRequest → Refund
- Inventory → Inventory movements

A Cart is a separate domain concept from an Order. A Cart represents a provisional product selection. An Order represents the formal purchase commitment.
