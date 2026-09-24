# UC-16 Gestionar envio

## Actor principal
Operador logístico

## Objetivo
Preparar, despachar y confirmar la entrega de un pedido.

## Precondiciones
- El pedido debe estar listo para envío.
- La dirección de entrega debe estar definida.

## Flujo principal
1. El sistema crea el envío asociado al pedido.
2. El operador prepara el pedido.
3. El sistema registra el despacho.
4. El sistema actualiza el estado del envío.
5. El sistema confirma la entrega.

## Postcondiciones
- El pedido queda identificado con guía, despacho y entrega finalizada.

## Servicios involucrados
- EnvioService

## Puertos de salida
- EnvioRepository
- LogisticaPort
