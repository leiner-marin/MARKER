# Domain core

Esta capa concentra la lógica de negocio y la intención del sistema NexusMarket.

## Estructura recomendada

- `models`: modelos del dominio para las entidades de negocio relevantes.
- `enums`: estados y tipos del negocio.
- `valueobjects`: objetos de valor reutilizables con validación propia.
- `exceptions`: reglas y validaciones de negocio que no deben convertirse en errores de infraestructura.
- `services`: servicios de dominio que coordinan la lógica del negocio.
- `ports/in`: casos de uso que representan el contrato de entrada.
- `ports/out`: puertos de persistencia, integración y notificación.

## Alcance

- Incorporación de vendedores.
- Catalogación y publicación de productos.
- Gestión de inventario.
- Compra, pago y logística.
- Cierre del ciclo de pedido.

## Principios

- El dominio no conoce la infraestructura.
- No se crean servicios innecesarios: cada servicio responde a una responsabilidad concreta.
- Las reglas de negocio viven en el dominio y deben mantenerse separadas de REST, JPA y adaptadores externos.
