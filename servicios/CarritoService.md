# CarritoService

## Objetivo
Gestionar la compra temporal antes de formalizar un pedido.

## Responsabilidad principal
Agregar y eliminar productos del carrito y transformarlo en un pedido válido.

## Reglas de negocio
- El carrito no puede quedar vacío al confirmar el pedido.
- La cantidad de cada producto debe ser válida.
- El pedido debe generarse a partir de la información del carrito.

## Métodos
- agregarProductoAlCarrito()
- eliminarProductoDelCarrito()
- confirmarPedido()
