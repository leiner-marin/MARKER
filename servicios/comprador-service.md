# CompradorService

## Responsabilidad
Registrar y gestionar la información comercial del comprador, direcciones y pedidos relacionados.

## Entidades involucradas
- Comprador
- Carrito
- Pedido

## Operaciones
- registrarComprador()
- actualizarDatos()
- agregarDireccion()
- actualizarDireccion()
- eliminarDireccion()
- consultarDirecciones()
- validarEstadoComercial()
- crearCarrito()
- confirmarPedido()
- consultarPedidos()
- solicitarDevolucion()
- consultarReembolsos()

## Puertos de salida utilizados
- CompradorRepository
- CarritoRepository
- PedidoRepository

## Entradas
- Datos de comprador y direcciones.

## Salidas
- Comprador creado/actualizado, carrito asociado, listado de pedidos.

## Errores o validaciones
- Dirección inválida.
- Comerciante no autorizado para ciertas operaciones.
