# ProductoService

## Responsabilidad
Registrar productos, asignar variantes, publicar, suspender, descontinuar y consultar catalogos.

## Implementacion
`src/application/services/ProductoService.java`

## Puertos
Depende de `ProductRepository` y no conoce la implementacion concreta.

## Flujo
`ProductoService -> ProductRepository -> InMemoryProductRepository`
