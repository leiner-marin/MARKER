# PreparacionPedidoService

## Objetivo
Gestionar la preparación del pedido cuando ya fue pagado y está listo para salir del almacén.

## Responsabilidad principal
Actualizar el estado del pedido desde la preparación hasta su despacho.

## Reglas de negocio
- El pedido debe existir antes de prepararse.
- La preparación debe registrar la hora de actualización.
- El pedido listo para envío se marca como Dispatched.

## Métodos
- prepararPedido()
- marcarPedidoListo()
