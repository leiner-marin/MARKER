# EstadoPedidoService

## Objetivo
Administrar la evolución del estado de un pedido a lo largo de su ciclo de compra y preparación.

## Responsabilidad principal
Actualizar el pedido y registrar la fecha de cambio cuando se modifica su estado.

## Reglas de negocio
- El estado nuevo debe ser obligatorio.
- El pedido debe existir antes de cambiarlo.
- La confirmación de pago mueve el pedido a Paid.

## Métodos
- actualizarEstadoPedido()
- confirmarPedido()
