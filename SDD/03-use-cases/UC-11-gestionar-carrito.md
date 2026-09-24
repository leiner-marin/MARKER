# UC-11 Gestionar carrito

## Actor principal
Comprador

## Objetivo
Agregar, modificar y confirmar productos dentro del carrito.

## Precondiciones
- El comprador debe estar registrado.
- El carrito debe existir o poder crearse.

## Flujo principal
1. El comprador agrega un producto al carrito.
2. El sistema valida disponibilidad y cantidad.
3. El sistema actualiza el detalle y total.
4. El comprador puede eliminar o ajustar productos.
5. El comprador confirma la compra.

## Postcondiciones
- El carrito queda actualizado y listo para convertirlo en pedido.

## Servicios involucrados
- CarritoService

## Puertos de salida
- CarritoRepository
- ProductoRepository
- InventarioRepository
