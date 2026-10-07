# BodegaService

## Objetivo
Gestionar la creación, clasificación y consulta de bodegas dentro del sistema.

## Responsabilidad principal
Registrar bodegas y permitir su consulta según el vendedor asociado y el tipo de operación.

## Reglas de negocio
- La bodega puede clasificarse como Marketplace o Vendedor.
- Cada bodega debe pertenecer a una entidad responsable.
- La consulta de bodegas por vendedor debe devolver todas las bodegas vinculadas a ese vendedor.

## Métodos
- registrarBodega()
- clasificarBodega()
- consultarBodegasPorVendedor()
