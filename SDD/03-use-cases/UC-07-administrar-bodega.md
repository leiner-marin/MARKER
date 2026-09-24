# UC-07 Administrar bodega

## Actor principal
Administrador o vendedor

## Objetivo
Consultar, habilitar, deshabilitar o actualizar una bodega.

## Precondiciones
- La bodega debe existir.
- El responsable debe tener permisos sobre la bodega.

## Flujo principal
1. El usuario solicita consultar o actualizar una bodega.
2. El sistema valida la existencia y permisos.
3. El sistema realiza la operación correspondiente.
4. El sistema registra el cambio.
5. El sistema responde la confirmación.

## Postcondiciones
- La bodega queda habilitada, deshabilitada o actualizada.

## Servicios involucrados
- BodegaService

## Puertos de salida
- BodegaRepository
- InventarioRepository
