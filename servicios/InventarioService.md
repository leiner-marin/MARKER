# InventarioService

## Objetivo
Controlar la disponibilidad real de productos en inventario.

## Responsabilidad principal
Gestionar entradas, salidas, reservas, devoluciones y validaciones de existencia.

## Reglas de negocio
- La existencia no puede quedar en valor negativo.
- La reserva de inventario debe validar que el producto exista y no esté dañado.
- Las salidas por venta deben validarse contra la cantidad disponible.

## Métodos
- registrarExistenciaInicial()
- registrarIngreso()
- reservarInventario()
- registrarSalidaPorVenta()
- ajustarInventario()
- registrarDevolucion()
- validarExistenciaNoNegativa()
