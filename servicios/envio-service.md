# EnvioService

## Responsabilidad
Orquestar la preparación, despacho y seguimiento de envíos.

## Entidades involucradas
- Envio
- Pedido
- OperadorLogistico

## Operaciones
- crearEnvio()
- prepararPedido()
- empacarPedido()
- despachar()
- actualizarEstado()
- confirmarEntrega()
- consultarEnvio()

## Puertos de salida utilizados
- EnvioRepository
- LogisticaPort

## Entradas
- Pedido y dirección de entrega.

## Salidas
- Envío creado y estado actualizado con número de guía.

## Errores o validaciones
- Dirección inválida.
- Error en integración con el proveedor logístico.
