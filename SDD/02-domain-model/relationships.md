# Modelo de dominio - Relaciones

## Relaciones principales

- Comprador → Carrito
- Comprador → Pedido
- Vendedor → Producto
- Producto → Inventario
- Bodega → Inventario
- Pedido → DetallePedido
- Pedido → Factura
- Pedido → Envio
- Pedido → Devolucion
- Devolucion → Reembolso
- Producto → Variante
- Inventario → MovimientoInventario

## Cardinalidad sugerida

- Un comprador puede tener un carrito activo y varios pedidos.
- Un vendedor puede administrar varios productos.
- Un producto puede estar presente en múltiples inventarios por bodega.
- Un pedido puede tener varios detalles, facturas y entregas asociadas.
- Un inventario genera múltiples movimientos de inventario.
- Una devolución puede generar un único reembolso.
