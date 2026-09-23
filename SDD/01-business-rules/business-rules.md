# Reglas de negocio

- Un producto inicia en estado `DRAFT` si no tiene estado definido.
- Un producto puede publicarse, suspenderse o descontinuarse mediante el servicio de aplicacion.
- El inventario no debe permitir existencias negativas.
- Un pedido debe validar disponibilidad antes de reservar existencias.
- El dominio no depende de una base de datos ni de servicios externos.

Estas reglas se ampliaran a partir de la especificacion funcional validada.
