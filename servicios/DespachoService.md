# DespachoService

## Objetivo
Crear y actualizar el proceso de despacho asociado a un pedido y una dirección de entrega.

## Responsabilidad principal
Generar una orden de envío con la bodega de origen y la dirección del destinatario.

## Reglas de negocio
- La orden, la bodega origen y la dirección de entrega son obligatorios.
- El envío debe registrarse con un estado inicial válido.
- El despacho actualiza la fecha de salida del pedido.

## Métodos
- despacharPedido()
- actualizarEstadoDespacho()
