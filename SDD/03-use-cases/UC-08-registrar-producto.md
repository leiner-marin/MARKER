# UC-08 Registrar producto

## Actor principal
Vendedor

## Objetivo
Registrar un nuevo producto dentro del catálogo del marketplace.

## Precondiciones
- El vendedor debe estar registrado y autorizado.
- La información del producto debe estar completa.

## Flujo principal
1. El vendedor solicita registrar un producto.
2. El sistema recibe la información del producto.
3. El sistema valida datos obligatorios y estado.
4. El sistema crea el producto.
5. El sistema almacena el producto.
6. El sistema confirma el registro.

## Postcondiciones
- El producto queda registrado en el catálogo.

## Servicios involucrados
- VendedorService
- ProductoService

## Puertos de salida
- VendedorRepository
- ProductoRepository
