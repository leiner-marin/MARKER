# CompradorService

## Objetivo
Administrar la información del comprador y su estado comercial dentro del ecosistema del marketplace.

## Responsabilidad principal
Registrar compradores, gestionar sus direcciones adicionales y controlar el estado comercial asociado.

## Reglas de negocio
- El comprador debe tener un correo válido al momento de registrarse.
- Las direcciones adicionales pueden agregarse o modificarse.
- El estado comercial puede cambiar según el flujo de activación o bloqueo del comprador.

## Métodos
- registrarComprador()
- gestionarDirecciones()
- consultarEstadoComercial()
- actualizarEstadoComercial()
