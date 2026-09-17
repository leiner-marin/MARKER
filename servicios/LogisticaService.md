# LogisticaService

## Objetivo
Gestionar la preparación, despacho y entrega del pedido.

## Responsabilidad principal
Coordinar la preparación del pedido, su envío y la confirmación de entrega al cliente.

## Reglas de negocio
- El pedido debe pasar por empacado antes de despacho.
- La entrega debe confirmarse para cerrar el ciclo del pedido.
- El estado de logística debe reflejar los pasos del envío.

## Métodos
- empacarPedido()
- despacharPedido()
- confirmarEntrega()
