# FacturacionService

## Objetivo
Generar y consultar facturas vinculadas a pedidos del sistema.

## Responsabilidad principal
Emitir comprobantes del proceso comercial y permitir su consulta posterior.

## Reglas de negocio
- La factura debe corresponder a un pedido válido.
- El monto debe ser mayor o igual a cero.
- La factura debe quedar asociada a la fecha de emisión.

## Métodos
- generarFactura()
- consultarFactura()
