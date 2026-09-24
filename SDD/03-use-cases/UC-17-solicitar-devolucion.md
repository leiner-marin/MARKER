# UC-17 Solicitar devolución

## Actor principal
Comprador

## Objetivo
Solicitar la devolución de un producto recibido o con problema.

## Precondiciones
- El pedido o producto debe estar asociado al comprador.
- Debe existir motivo válido para la devolución.

## Flujo principal
1. El comprador solicita la devolución.
2. El sistema valida el pedido, el producto y el motivo.
3. El sistema crea la solicitud de devolución.
4. El sistema registra la operación.
5. El sistema confirma la solicitud.

## Postcondiciones
- La devolución queda registrada para revisión o aprobación.

## Servicios involucrados
- DevolucionService

## Puertos de salida
- DevolucionRepository
- InventarioRepository
