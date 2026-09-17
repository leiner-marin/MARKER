# UsuarioService

## Objetivo
Gestionar la identidad del usuario, su estado operativo y la validación de unicidad dentro del sistema.

## Responsabilidad principal
Controlar el registro, la consulta del estado y la verificación de restricciones asociadas a cada usuario.

## Reglas de negocio
- RG-01: la autenticación del usuario no forma parte del alcance técnico, pero es una regla de negocio obligatoria.
- El usuario debe contar con un correo electrónico válido.
- Un usuario debe tener un estado válido: Activo o Bloqueado.
- No pueden existir duplicados de documento ni de correo para el mismo perfil.

## Métodos
- registrarUsuario()
- autenticarUsuario()
- consultarEstadoUsuario()
- actualizarEstado()
- validarUnicidad(documento, correo)
