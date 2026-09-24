# Modelo de dominio - Clases

## Entidades principales

### Usuario
- identificador: String
- nombreCompleto: String
- correoElectronico: String
- rol: Rol
- estado: EstadoUsuario

### Comprador
- direccionPrincipal: String
- direccionesAdicionales: List<String>
- estadoComercial: EstadoComercial

### Vendedor
- idVendedor: String
- nombreComercial: String
- estado: EstadoVendedor

### Bodega
- idBodega: String
- nombre: String
- direccion: String
- tipoBodega: TipoBodega
- estado: EstadoBodega

### Producto
- idProducto: String
- nombre: String
- descripcion: String
- precio: BigDecimal
- tipoProducto: TipoProducto
- variantes: List<Variante>
- estado: EstadoProducto

### Variante
- idVariante: String
- color: String
- talla: String
- modelo: String

### Inventario
- idInventario: String
- producto: Producto
- bodega: Bodega
- existencias: int

### MovimientoInventario
- idMovimiento: String
- tipoMovimiento: TipoMovimiento
- cantidad: int
- fecha: LocalDateTime
- inventario: Inventario

### Carrito
- idCarrito: String
- comprador: Comprador
- detalles: List<DetalleCarrito>
- total: BigDecimal

### DetalleCarrito
- producto: Producto
- cantidad: int
- precioUnitario: BigDecimal
- subtotal: BigDecimal

### Pedido
- idPedido: String
- comprador: Comprador
- fechaPedido: LocalDateTime
- detalles: List<DetallePedido>
- total: BigDecimal
- estado: EstadoPedido

### DetallePedido
- producto: Producto
- cantidad: int
- precioUnitario: BigDecimal
- subtotal: BigDecimal

### Pago
- idPago: String
- pedido: Pedido
- monto: BigDecimal
- fechaPago: LocalDateTime
- estadoPago: EstadoPago
- metodoPago: String

### Factura
- idFactura: String
- numeroFactura: String
- fechaEmision: LocalDateTime
- pedido: Pedido
- subtotal: BigDecimal
- impuestos: BigDecimal
- total: BigDecimal

### Envio
- idEnvio: String
- pedido: Pedido
- direccionEntrega: String
- numeroGuia: String
- estadoEnvio: EstadoEnvio
- fechaDespacho: LocalDateTime
- fechaEntrega: LocalDateTime

### Devolucion
- idDevolucion: String
- pedido: Pedido
- producto: Producto
- motivo: String
- fechaSolicitud: LocalDateTime
- estado: EstadoDevolucion

### Reembolso
- idReembolso: String
- devolucion: Devolucion
- monto: BigDecimal
- fecha: LocalDateTime
- estado: EstadoReembolso

### ReporteAdministrativo
- idReporte: String
- tipoReporte: String
- fechaGeneracion: LocalDateTime
- datos: String
