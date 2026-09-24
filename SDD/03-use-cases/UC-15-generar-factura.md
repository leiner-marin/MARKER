# UC-15 Generar factura

## Actor principal
Administrador o sistema

## Objetivo
Emitir la factura asociada a un pedido pagado.

## Precondiciones
- El pedido debe existir.
- Debe validarse el estado del pedido antes de la facturación.

## Flujo principal
1. El sistema detecta un pedido listo para facturar.
2. Se calculan subtotal, impuestos y total.
3. Se genera la factura.
4. El sistema guarda la factura.
5. El sistema confirma la emisión.

## Postcondiciones
- La factura queda almacenada y asociada al pedido.

## Servicios involucrados
- FacturaService
- PedidoService

## Puertos de salida
- FacturaRepository
- FacturacionPort
