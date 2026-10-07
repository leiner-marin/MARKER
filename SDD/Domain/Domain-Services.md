# Domain Services

## Propósito
Los servicios de dominio encapsulan lógica que no pertenece exclusivamente a una entidad, pero sí al núcleo del negocio.

## Servicios principales
- UsuarioService
- ValidacionUsuarioService
- CompradorService
- DireccionCompradorService
- VendedorService
- IncorporacionVendedorService
- BodegaService
- AsignacionBodegaService
- ProductoService
- ProductoPublicacionService
- VarianteProductoService
- CatalogoService
- InventarioService
- ReservaInventarioService
- MovimientoInventarioService
- AjusteInventarioService
- PedidoService
- EstadoPedidoService
- ValidacionPedidoService
- PagoService
- FacturacionService
- PreparacionPedidoService
- DespachoService
- EntregaService
- DevolucionService
- ReembolsoService
- ReporteAdministrativoService

## Regla
Cada servicio debe validar precondiciones, errores y reglas del negocio antes de ejecutar la operación.
