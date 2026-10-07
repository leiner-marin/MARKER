# VarianteProductoService

## Objetivo
Gestionar las variantes de un producto para soportar diferentes atributos, combinaciones o presentaciones.

## Responsabilidad principal
Asociar una lista de variantes a los productos y mantenerlas actualizadas según la oferta comercial.

## Reglas de negocio
- El producto debe ser válido antes de asignar variantes.
- La lista puede quedar vacía si se desea limpiar la configuración.
- Las variantes deben registrarse como cadenas de texto válidas.

## Métodos
- asignarVariantes()
- agregarVariante()
