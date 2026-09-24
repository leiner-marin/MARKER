# BodegaService

## Responsabilidad
Registrar y administrar bodegas; exponer inventario asociado a cada bodega.

## Entidades involucradas
- Bodega
- Inventario
- Vendedor

## Operaciones
- registrarBodega()
- actualizarBodega()
- consultarBodega()
- habilitarBodega()
- deshabilitarBodega()
- consultarInventario()

## Puertos de salida utilizados
- BodegaRepository
- InventarioRepository

## Entradas
- Datos de la bodega (dirección, tipo, estado).

## Salidas
- Bodega creada/actualizada, listas de inventario.

## Errores o validaciones
- Tipo de bodega no válido.
- Bodega asociada a vendedor inexistente.
