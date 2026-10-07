# ReporteService

## Responsabilidad
Generar reportes administrativos (ventas, inventario, pedidos, logística).

## Entidades involucradas
- ReporteAdministrativo
- Pedido
- Inventario
- Envio

## Operaciones
- generarReporte()
- consultarReporte()
- filtrarReporte()
- generarReporteVentas()
- generarReporteInventario()
- generarReportePedidos()
- generarReporteLogistica()

## Puertos de salida utilizados
- ReportePort

## Entradas
- Parámetros de filtrado y periodo.

## Salidas
- Reporte en formato consultable o archivo exportable.

## Errores o validaciones
- Falta de permisos para acceder a datos consolidados.

## Implementación Java
`src/main/java/application/services/ReporteService.java`
