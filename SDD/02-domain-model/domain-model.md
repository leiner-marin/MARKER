# Modelo de dominio

Las entidades Java viven en `application.domain.entities` y los estados en `application.domain.enums`.

Entidades actuales: `User`, `Buyer`, `Seller`, `Administrator`, `Supervisor`, `Warehouse`, `Product`, `Inventory`, `Order`, `Invoice`, `Shipment` y `LogisticsOperator`.

Los estados comerciales, de vendedor, pago y envio tambien se representan mediante enums; no se usan `String` para controlar transiciones de estado.

Las entidades no contienen dependencias de JPA, SQL Server, MongoDB ni APIs externas.
