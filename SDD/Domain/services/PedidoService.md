# PedidoService

## Objetivo
Administrar el ciclo de vida del pedido desde su creación hasta su finalización.

## Responsabilidad principal
Crear pedidos, cambiar su estado y bloquear modificaciones cuando el pedido ya ha sido finalizado.

## Reglas de negocio
- El pedido debe tener un estado inicial válido.
- El estado cambia según el ciclo definido por el negocio.
- Un pedido finalizado no debe permitir cambios adicionales.

## Métodos
- crearPedido()
- cambiarEstadoPedido()
- validarPedidoFinalizado()
- consultarPedido()
