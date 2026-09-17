# VendedorService

## Objetivo
Administrar la información del vendedor y su activación dentro del marketplace.

## Responsabilidad principal
Registrar al vendedor, asociarlo a su primera bodega y mantener su información actualizada.

## Reglas de negocio
- El registro de vendedor solo puede ejecutarse por un Administrador.
- Cada vendedor puede tener una o varias bodegas asociadas.
- La información del vendedor debe poder actualizarse sin afectar su identidad.

## Métodos
- registrarVendedor()
- asignarPrimeraBodega()
- consultarVendedor()
- actualizarInformacionVendedor()
