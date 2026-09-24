# UC-18 Procesar reembolso

## Actor principal
Administrador o sistema

## Objetivo
Gestionar el reembolso asociado a una devolución aprobada.

## Precondiciones
- La devolución debe existir y estar aprobada.
- Debe existir un monto válido a devolver.

## Flujo principal
1. El sistema identifica la devolución aprobada.
2. El sistema calcula el monto de reembolso.
3. El sistema invoca la operación de pago externa.
4. El sistema registra el estado del reembolso.
5. El sistema confirma la operación.

## Postcondiciones
- El reembolso queda procesado y asociado a la devolución.

## Servicios involucrados
- ReembolsoService
- PagoService

## Puertos de salida
- ReembolsoRepository
- PagoPort
