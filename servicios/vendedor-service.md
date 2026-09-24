# VendedorService

## Responsabilidad
Registrar y gestionar vendedores y operaciones relacionadas a sus productos e inventario.

## Entidades involucradas
- Vendedor
- Producto
- Inventario

## Operaciones
- registrarVendedor()
- actualizarVendedor()
- consultarVendedor()
- registrarProducto()
- actualizarProducto()
- publicarProducto()
- suspenderProducto()
- descontinuarProducto()
- consultarProductos()
- consultarInventario()

## Puertos de salida utilizados
- VendedorRepository
- ProductoRepository
- InventarioRepository

## Entradas
- Datos del vendedor y del producto.

## Salidas
- Vendedor/producto registrado o actualizado.

## Errores o validaciones
- Datos comerciales incompletos.
- Intento de publicar producto sin inventario.
