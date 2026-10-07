# PedidoService

## Responsabilidad
Crear y gestionar el ciclo de vida de los pedidos.

## Entidades involucradas
- Pedido
- DetallePedido
- Comprador
- Inventario

## Implementación Java
`src/main/java/application/services/PedidoService.java`

## Operaciones
- crearPedido()
- consultarPedido()
- calcularTotal()
- cambiarEstado()
- confirmarPago()
- marcarPagado()
- marcarDespachado()
- marcarEntregado()
- finalizarPedido()
- validarModificacion()

## Puertos de salida utilizados
- PedidoRepository
- InventarioRepository
- PagoPort

## Entradas
- Carrito confirmado o detalles de pedido.

## Salidas
- Pedido creado y estados actualizados.

## Errores o validaciones
- Pedido finalizado no modificable.
- No hay disponibilidad suficiente.
