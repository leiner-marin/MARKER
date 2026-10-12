# Domain Model

The MARKER domain is implemented under `application.domain`.

## Main Entities

User, Buyer, Seller, Administrator, Supervisor, LogisticsOperator, Warehouse, Product, Inventory, Cart, Order, Payment, Invoice, Shipment, ReturnRequest, Refund, and AdministrativeReport.

## Domain Boundaries

Domain entities, services, value objects, enums, and exceptions contain business concepts only.

They must not depend on Spring, JPA, REST, HTTP, or database-specific implementations.

Persistence and external systems interact with the domain through ports.
