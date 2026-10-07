# AjusteInventarioService

## Objetivo
Ajustar la cantidad disponible de inventario cuando se requiere corregir o sincronizar el stock real.

## Responsabilidad principal
Establecer un valor nuevo de inventario y registrar la operación como ajuste.

## Reglas de negocio
- La nueva cantidad debe ser un valor válido y no negativo.
- El ajuste debe reflejarse con tipo de movimiento Adjustment.
- La fecha del ajuste se registra automáticamente.

## Métodos
- ajustarInventario()
