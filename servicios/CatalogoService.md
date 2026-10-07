# CatalogoService

## Objetivo
Mantener el catálogo de productos asociado a un vendedor dentro del sistema de marketplace.

## Responsabilidad principal
Agregar y consultar productos disponibles dentro del catálogo del vendedor.

## Reglas de negocio
- El vendedor debe existir para registrar productos en su catálogo.
- El producto no puede ser nulo.
- Un producto se asocia al vendedor al agregarse al catálogo.

## Métodos
- agregarProductoCatalogo()
- obtenerCatalogo()
