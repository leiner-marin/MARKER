# ValidacionPedidoService

## Objetivo
Validar que el pedido contenga la información mínima necesaria para ser atendido correctamente.

## Responsabilidad principal
Garantizar que el pedido tenga comprador y productos antes de continuar con el flujo comercial.

## Reglas de negocio
- El pedido no puede ser nulo.
- El buyer es requerido.
- Debe existir al menos un producto en la compra.

## Métodos
- validarPedido()
- tieneProductosValidados()
