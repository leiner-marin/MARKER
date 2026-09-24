# UC-13 Procesar pago

## Actor principal
Comprador

## Objetivo
Validar y registrar el pago de un pedido.

## Precondiciones
- El pedido debe existir.
- Debe existir un método de pago válido.

## Flujo principal
1. El comprador solicita procesar el pago.
2. El sistema valida el estado del pedido.
3. El sistema invoca el puerto externo de pagos.
4. El sistema valida la respuesta del proveedor.
5. El sistema actualiza el estado del pago y del pedido.

## Postcondiciones
- El pedido queda pagado o rechazado con trazabilidad del resultado.

## Servicios involucrados
- PagoService
- PedidoService

## Puertos de salida
- PagoPort
