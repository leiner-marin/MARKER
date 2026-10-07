# EntregaService

## Objetivo
Registrar la entrega efectiva de un envío al comprador y cerrar el ciclo logístico del pedido.

## Responsabilidad principal
Actualizar el estado de la entrega y guardar la fecha en la que se completó la operación.

## Reglas de negocio
- El envío debe existir antes de registrarse como entregado.
- El estado final del envío debe ser Delivered.
- La fecha de entrega se registra automáticamente si no se suministra.

## Métodos
- entregarPedido()
- registrarEntrega()
