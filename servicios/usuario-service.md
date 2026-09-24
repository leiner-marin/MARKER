# UsuarioService

## Responsabilidad
Gestionar el ciclo de vida y estado de los usuarios (registro, actualización, bloqueo, roles).

## Implementación Java
`src/main/java/application/services/UsuarioService.java`

## Entidades involucradas
- Usuario
- Comprador
- Vendedor

## Operaciones
- registrarUsuario()
- actualizarDatos()
- consultarUsuario()
- cambiarEstado()
- bloquearUsuario()
- activarUsuario()
- asignarRol()

## Puertos de salida utilizados
- UsuarioRepository

## Entradas
- DTO de registro/actualización con `nombreCompleto`, `correoElectronico`, `rol`.

## Salidas
- Usuario creado/actualizado.

## Errores o validaciones
- Correo duplicado.
- Campos obligatorios faltantes.
- Permisos insuficientes para ciertas actualizaciones.
