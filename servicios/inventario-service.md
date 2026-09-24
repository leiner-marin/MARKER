# InventarioService

## Responsabilidad
Registrar, ajustar y consultar existencias distribuidas por bodega.

## Entidades involucradas
- Inventario
- Producto
- Bodega
- MovimientoInventario

## Operaciones
- registrarExistencias()
- consultarExistencias()
- ingresarProducto()
- reservarProducto()
- registrarSalidaVenta()
- ajustarInventario()
- registrarDevolucion()
- validarDisponibilidad()
- validarExistencias()

## Puertos de salida utilizados
- InventarioRepository
- MovimientoInventarioRepository

## Entradas
- Id producto, id bodega, cantidad y tipo de movimiento.

## Salidas
- Confirmación de movimiento y nuevo saldo.

## Errores o validaciones
- No se permiten existencias negativas.
- No reservar más que el disponible.
