# DevolucionService

## Responsabilidad
Gestionar solicitudes de devolución y su posterior validación.

## Entidades involucradas
- Devolucion
- Pedido
- Producto

## Implementación Java
`src/main/java/application/services/DevolucionService.java`

## Operaciones
- solicitarDevolucion()
- registrarDevolucion()
- aprobarDevolucion()
- rechazarDevolucion()
- consultarDevolucion()

## Puertos de salida utilizados
- DevolucionRepository
- InventarioRepository

## Entradas
- Pedido, producto y motivo de devolución.

## Salidas
- Solicitud de devolución registrada y su estado.

## Errores o validaciones
- Solicitud fuera de plazo.
- Producto no elegible para devolución.
