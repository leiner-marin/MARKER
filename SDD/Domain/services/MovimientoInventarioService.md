# MovimientoInventarioService

## Objetivo
Registrar y actualizar los movimientos del inventario relacionados con ingresos, salidas y ajustes de stock.

## Responsabilidad principal
Controlar los cambios de disponibilidad del inventario según el tipo de movimiento registrado.

## Reglas de negocio
- El tipo de movimiento es obligatorio.
- La cantidad debe ser mayor o igual a cero para movimientos válidos.
- Cada movimiento registra la fecha y el tipo de operación.

## Métodos
- registrarMovimiento()
