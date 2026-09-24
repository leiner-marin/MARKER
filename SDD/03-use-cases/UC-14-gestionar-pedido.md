# UC-14 Gestionar pedido

## Actor principal
Comprador o administrador

## Objetivo
Consultar el estado del pedido y cambiarlo conforme al flujo de negocio.

## Precondiciones
- El pedido debe existir.
- El cambio de estado debe seguir una secuencia válida.

## Flujo principal
1. El actor solicita consultar o actualizar un pedido.
2. El sistema valida el estado actual.
3. El sistema aplica la transición de estado.
4. El sistema confirma la actualización.

## Postcondiciones
- El pedido queda en el nuevo estado solicitado.

## Servicios involucrados
- PedidoService

## Puertos de salida
- PedidoRepository
- PagoPort
