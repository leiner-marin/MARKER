# UC-12 Crear pedido

## Actor principal
Comprador

## Objetivo
Generar un pedido a partir del carrito confirmado.

## Precondiciones
- El carrito debe tener productos válidos.
- Debe existir disponibilidad suficiente.

## Flujo principal
1. El comprador confirma el carrito.
2. El sistema calcula el total final.
3. El sistema valida la disponibilidad.
4. El sistema crea el pedido y sus detalles.
5. El sistema registra el estado inicial.

## Postcondiciones
- El pedido queda generado y pendiente de pago o validación.

## Servicios involucrados
- PedidoService
- CarritoService

## Puertos de salida
- PedidoRepository
- InventarioRepository
