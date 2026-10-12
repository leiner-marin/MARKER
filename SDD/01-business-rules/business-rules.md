# Business Rules

## Global Rules

### BR-01
Every operation must be executed by an authenticated user.

### BR-02
Each user has exactly one role.

### BR-03
Participants may only administer information within the permissions of their role.

### BR-04
The user identifier must be unique.

### BR-05
The user email must be unique.

### BR-06
Inventory stock must never become negative.

### BR-07
Inventory cannot be reserved when it does not exist or is marked as damaged.

### BR-08
A finalized order cannot be modified.

### BR-09
User, product, and order states must remain within their defined domain catalogs.

## Domain Rules

### Inventory
- Available stock must be validated before reservation or sale.
- Inventory movements must be recorded for traceability.

### Orders
- Orders may only transition through valid lifecycle states.
- Finalization closes the order and prevents further modification.

### Users
- Required information must be complete before registration.
- The role determines the permitted operations.

### Products
- A product must belong to a seller or marketplace offer.
- Product type and status must follow the defined domain catalog.

### Warehouses
- A warehouse must have a valid type.
- Inventory must be associated with a valid product and warehouse.
