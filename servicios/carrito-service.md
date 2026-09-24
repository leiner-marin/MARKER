# CarritoService

## Responsabilidad
Gestionar la creación y modificación de carritos de compra y su conversión a pedido.

## Entidades involucradas
- Carrito
- DetalleCarrito
- Producto
- Comprador

## Implementación Java
`src/main/java/application/services/CarritoService.java`

## Operaciones
- crearCarrito()
- agregarProducto()
- eliminarProducto()
- actualizarCantidad()
- vaciarCarrito()
- calcularTotal()
- consultarCarrito()
- confirmarCompra()

## Puertos de salida utilizados
- CarritoRepository
- ProductoRepository
- InventarioRepository

## Entradas
- Id comprador, producto y cantidad.

## Salidas
- Carrito actualizado y total calculado.

## Errores o validaciones
- Producto no disponible.
- Cantidad excede disponibilidad.
