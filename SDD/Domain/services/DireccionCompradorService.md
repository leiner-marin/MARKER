# DireccionCompradorService

## Objetivo
Administrar las direcciones asociadas a un comprador, incluyendo su dirección principal y sus direcciones adicionales.

## Responsabilidad principal
Mantener un registro consistente de ubicaciones del comprador para pedidos, envíos y validaciones operativas.

## Reglas de negocio
- La dirección principal es obligatoria al registrar el perfil del comprador.
- Una dirección adicional no debe quedar vacía.
- El comprador debe poder consultar todas sus direcciones registradas.

## Métodos
- registrarDireccionPrincipal()
- agregarDireccionAdicional()
- listarDirecciones()
