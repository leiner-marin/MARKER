# Business Rules

## Global Rules

### BR-01
Every operation must be executed by an authenticated user.

### BR-02
Each user has exactly one role.

### BR-03
Participants may only administer information within the permissions of their role.

### BR-04
The system identifier and identity document must be unique for users.

### BR-05
The user email must be unique.

### BR-06
Inventory stock must never become negative.

### BR-07
Inventory cannot be reserved when it does not exist or is marked as damaged.

### BR-08
A finalized order cannot be modified.

### BR-09
User, product, order, and inventory movement states must remain within their defined domain catalogs.

### BR-10
Sellers cannot self-register; seller incorporation is an administrator operation.

### BR-11
Physical products require inventory and physical shipment.

### BR-12
Digital products do not require physical shipment and are finalized after successful payment.

## Domain Rules

### Inventory
- Available stock must be validated before reservation or sale.
- Inventory movements must be recorded for traceability.

### Orders
- Orders may only transition through valid lifecycle states.
- Finalization closes the order and prevents further modification.
- Order products must be identified and published before the order is created.

### Users
- Required identity information must be complete before registration.
- Identity document and email are unique.
- The role determines the permitted operations.

### Products
- A product must belong to a seller.
- Product type and status follow the defined domain catalogs.
- Registration and publication are separate business operations.

### Warehouses
- A warehouse must have a valid type.
- Inventory must be associated with a valid product and warehouse.
