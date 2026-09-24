# UC-10 Gestionar inventario

## Actor principal
Vendedor o administrador

## Objetivo
Registrar, consultar y ajustar existencias del inventario.

## Precondiciones
- Debe existir un producto asociado a una bodega válida.
- El usuario debe tener permisos sobre la bodega.

## Flujo principal
1. El usuario solicita consultar o ajustar inventario.
2. El sistema valida el producto y la bodega.
3. El sistema calcula o actualiza existencias.
4. El sistema registra el movimiento según el tipo.
5. El sistema confirma el resultado.

## Postcondiciones
- El inventario queda actualizado con trazabilidad del movimiento.

## Servicios involucrados
- InventarioService

## Puertos de salida
- InventarioRepository
- MovimientoInventarioRepository
