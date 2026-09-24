# UC-06 Registrar bodega

## Actor principal
Administrador o vendedor

## Objetivo
Registrar una bodega para almacenamiento y gestión de inventario.

## Precondiciones
- La entidad responsable debe estar registrada.
- Debe existir información de dirección y tipo de bodega.

## Flujo principal
1. El usuario solicita registrar una bodega.
2. El sistema valida los datos obligatorios.
3. El sistema crea la bodega.
4. El sistema asocia el tipo y estado.
5. El sistema confirma el registro.

## Postcondiciones
- La bodega queda disponible para uso operativo.

## Servicios involucrados
- BodegaService

## Puertos de salida
- BodegaRepository
