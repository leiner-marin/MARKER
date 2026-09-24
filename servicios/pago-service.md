# PagoService

## Responsabilidad
Procesar y validar pagos a través del `PagoPort`.

## Entidades involucradas
- Pago
- Pedido

## Implementación Java
`src/main/java/application/services/PagoService.java`

## Operaciones
- procesarPago()
- validarPago()
- aprobarPago()
- rechazarPago()
- consultarPago()

## Puertos de salida utilizados
- PagoPort

## Entradas
- Información de pago (metodo, monto, pedido).

## Salidas
- Estado del pago y actualización del pedido.

## Errores o validaciones
- Pago rechazado por el proveedor.
- Datos de tarjeta inválidos.
