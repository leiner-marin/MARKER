# InventarioRepository

## Responsabilidad
Gestionar la persistencia y consulta del inventario distribuido.

## Operaciones
- guardar(inventario)
- actualizar(inventario)
- buscarPorId(idInventario)
- buscarPorProducto(idProducto)
- buscarPorBodega(idBodega)
- buscarDisponibilidad(idProducto)
- consultarDisponibilidad(idProducto, cantidad)
- reservar(idProducto, cantidad)
- descontar(idProducto, cantidad)
- devolver(idProducto, cantidad)

## Casos de uso vinculados
- UC-10 Gestionar inventario
- UC-12 Crear pedido
