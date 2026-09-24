# UC-19 Generar reporte

## Actor principal
Administrador o supervisor

## Objetivo
Generar reportes administrativos de ventas, pedidos, inventario y logística.

## Precondiciones
- El usuario debe tener permisos de consulta.
- Debe existir información consolidada del negocio.

## Flujo principal
1. El actor solicita un tipo de reporte.
2. El sistema identifica la fuente de datos.
3. El sistema procesa los datos en la capa de reportes.
4. El sistema genera el documento o resultado.
5. El sistema entrega el reporte al usuario.

## Postcondiciones
- El reporte queda generado y disponible para consulta.

## Servicios involucrados
- ReporteService

## Puertos de salida
- ReportePort
