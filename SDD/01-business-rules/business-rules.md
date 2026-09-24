# Reglas de negocio

## Reglas globales

### RG-01
Toda operación debe ejecutarse por un usuario autenticado.

### RG-02
Cada usuario tendrá un único rol dentro del sistema.

### RG-03
Ningún participante podrá administrar información fuera de su rol.

### RG-04
El identificador del usuario debe ser único.

### RG-05
El correo electrónico del usuario debe ser único.

### RG-06
No se permiten existencias negativas en el inventario.

### RG-07
No se puede reservar inventario inexistente o marcado como dañado.

### RG-08
Un pedido finalizado no puede modificarse.

### RG-09
Los estados de producto, pedido y usuario deben permanecer dentro de su catálogo definido.

## Reglas por dominio

### Inventario
- La disponibilidad real debe validarse antes de una reserva o de una venta.
- El movimiento de inventario debe quedar registrado para mantener trazabilidad.

### Pedidos
- Un pedido solo puede cambiar de estado dentro de un flujo válido.
- El estado final exige cierre y bloqueo de modificaciones.

### Usuarios
- Los datos principales deben estar completos antes de registrar un usuario.
- El rol determina qué operaciones puede ejecutar el usuario.

### Productos
- El producto debe pertenecer a un vendedor o a la oferta del marketplace.
- Los tipos y estados deben respetar el catálogo del dominio.

### Bodegas
- Una bodega debe tener un tipo y un estado definidos.
- La gestión de inventario debe estar asociada a una bodega válida.
