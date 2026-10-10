# REST API

REST exposes application use cases through HTTP.

## Structure
application/adapters/rest/
- controllers/
- dtos/
- mappers/
- exception/

## Request flow
HTTP Request → Request DTO → Mapper → Input Port → Use Case → Domain Service → Output Port → Adapter → Response DTO

Controllers must not call repositories or domain services directly.

## Business areas
Users, buyers, sellers, warehouses, products, inventory, cart, orders, payments, invoices, shipments, deliveries, returns, refunds, and administrative reports.

Request validation belongs at the REST boundary. Business validation belongs in the domain.