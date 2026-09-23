# Arquitectura

```text
application.domain.entities / enums
              ^
application.services
              |
application.ports.out
              |
application.infrastructure.repositories
```

Los contratos de salida existentes estan en `application.ports.out`. La implementacion actual de Producto es `InMemoryProductRepository`; posteriormente puede sustituirse por un adaptador SQL Server sin modificar `ProductoService`.
