# AsignacionBodegaService

## Objetivo
Relacionar cada bodega con el vendedor responsable y mantener la asociación entre ambos actores del negocio.

## Responsabilidad principal
Asignar la propiedad de una bodega y exponer la lista de bodegas asociadas a un vendedor.

## Reglas de negocio
- La bodega y el vendedor deben existir antes de asignarla.
- La bodega queda vinculada al vendedor propietario.
- No se duplican asociaciones entre vendedor y bodega.

## Métodos
- asignarBodega()
- listarBodegas()
