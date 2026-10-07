# ProductoService

## Objetivo
Administrar el catálogo de productos y su ciclo de vida dentro del marketplace.

## Responsabilidad principal
Registrar, categorizar, publicar, suspender y descontinuar productos.

## Reglas de negocio
- Un producto puede tener varias variantes.
- El producto debe estar publicado para ser visible en el catálogo.
- Los productos suspendidos o descontinuados no deben estar disponibles para venta.

## Métodos
- registrarProducto()
- definirVariantes()
- publicarProducto()
- suspenderProducto()
- descontinuarProducto()
- consultarCatalogo()
