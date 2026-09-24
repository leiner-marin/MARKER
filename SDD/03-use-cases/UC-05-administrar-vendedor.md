# UC-05 Administrar vendedor

## Actor principal
Administrador

## Objetivo
Actualizar y consultar la información del vendedor y sus productos.

## Precondiciones
- El vendedor debe existir.
- El administrador debe tener permisos de gestión.

## Flujo principal
1. El administrador solicita consultar o actualizar al vendedor.
2. El sistema valida la existencia del vendedor.
3. El sistema actualiza los datos o consulta información.
4. El sistema confirma la acción.

## Postcondiciones
- La información del vendedor queda actualizada o consultada.

## Servicios involucrados
- VendedorService
- ProductoService

## Puertos de salida
- VendedorRepository
- ProductoRepository
