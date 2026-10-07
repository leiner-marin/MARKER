# ProductoService

## Responsabilidad
Gestionar el ciclo de vida de los productos del Marketplace.

## Entidades involucradas
- Producto
- Vendedor
- Variante
- Inventario

## Implementación Java
`src/main/java/application/services/ProductoService.java`

## Operaciones
- registrarProducto()
- actualizarProducto()
- consultarProducto()
- publicarProducto()
- suspenderProducto()
- descontinuarProducto()
- cambiarPrecio()
- agregarVariante()
- eliminarVariante()
- validarDisponibilidad()

## Puertos de salida utilizados
- ProductoRepository
- InventarioRepository

## Entradas
- Datos del producto, variantes y precio.

## Salidas
- Producto creado/actualizado, estado publicado.

## Errores o validaciones
- Precio inválido.
- Variantes inconsistentes.
- Intento de publicar sin inventario disponible.
