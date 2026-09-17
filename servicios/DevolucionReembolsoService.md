# DevolucionReembolsoService

## Objetivo
Gestionar solicitudes de devolución y reembolso asociadas a pedidos.

## Responsabilidad principal
Atender devoluciones, validar la solicitud y procesar el reembolso correspondiente.

## Reglas de negocio
- Una devolución debe estar asociada a un pedido válido.
- El motivo puede ser solicitado por el cliente o por el analista.
- El reembolso debe registrarse con su estado actual.

## Métodos
- solicitarDevolucion()
- procesarReembolso()
- consultarEstadoDevolucion()
