# FacturaService

## Responsabilidad
Generar y gestionar facturas asociadas a pedidos pagados.

## Entidades involucradas
- Factura
- Pedido

## Implementación Java
`src/main/java/application/services/FacturaService.java`

## Operaciones
- generarFactura()
- consultarFactura()
- calcularSubtotal()
- calcularTotal()
- anularFactura()

## Puertos de salida utilizados
- FacturaRepository
- FacturacionPort

## Entradas
- Pedido con estado válido para facturación.

## Salidas
- Factura generada y asociada al pedido.

## Errores o validaciones
- Pedido no válido para facturar.
- Errores en cálculo de impuestos.
