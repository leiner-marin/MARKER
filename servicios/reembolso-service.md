# ReembolsoService

## Responsabilidad
Procesar reembolsos resultantes de devoluciones aprobadas.

## Entidades involucradas
- Reembolso
- Devolucion
- Pago

## Implementación Java
`src/main/java/application/services/ReembolsoService.java`

## Operaciones
- crearReembolso()
- procesarReembolso()
- aprobarReembolso()
- rechazarReembolso()
- consultarReembolso()

## Puertos de salida utilizados
- ReembolsoRepository
- PagoPort

## Entradas
- Devolución aprobada y monto a reembolsar.

## Salidas
- Registro del reembolso y estado de ejecución.

## Errores o validaciones
- Monto inválido.
- Fallo en la ejecución del reembolso por el proveedor de pagos.
