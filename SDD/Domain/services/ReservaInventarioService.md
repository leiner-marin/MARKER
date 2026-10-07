# ReservaInventarioService

## Objetivo
Reservar unidades de inventario para evitar sobreventa mientras se procesa una operación comercial.

## Responsabilidad principal
Reducir la disponibilidad de stock cuando se confirma una reserva y validar la cantidad disponible.

## Reglas de negocio
- La cantidad reservada debe ser mayor a cero.
- Debe haber stock suficiente para cubrir la reserva.
- La reserva debe dejar registro del movimiento y la fecha.

## Métodos
- reservar()
