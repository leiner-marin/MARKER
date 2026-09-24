# UC-09 Publicar producto

## Actor principal
Vendedor

## Objetivo
Publicar un producto para que esté disponible para la venta.

## Precondiciones
- El producto debe estar registrado.
- El producto no debe estar descontinuado ni suspendido indefinidamente.

## Flujo principal
1. El vendedor solicita publicar el producto.
2. El sistema valida el estado actual del producto.
3. El sistema cambia el estado a PUBLICADO.
4. El sistema actualiza el catálogo.
5. El sistema confirma la publicación.

## Postcondiciones
- El producto queda disponible para su venta.

## Servicios involucrados
- ProductoService

## Puertos de salida
- ProductoRepository
- InventarioRepository
