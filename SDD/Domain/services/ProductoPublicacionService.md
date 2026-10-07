# ProductoPublicacionService

## Objetivo
Controlar el ciclo de publicación de productos y sus cambios de estado para la visibilidad comercial.

## Responsabilidad principal
Publicar, retirar o suspender productos según las reglas de negocio y las condiciones del catálogo.

## Reglas de negocio
- Un producto debe existir antes de publicarse.
- La publicación cambia el estado del producto a Published.
- La retirada o suspensión indica que el producto ya no está disponible para venta.

## Métodos
- publicarProducto()
- retirarPublicacion()
- suspenderProducto()
