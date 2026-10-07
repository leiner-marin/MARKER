# ValidacionUsuarioService

## Objetivo
Validar la integridad y el estado de los usuarios del sistema antes de permitir su registro, actualización o acceso.

## Responsabilidad principal
Comprobar que los datos básicos del usuario sean válidos y asignar valores por defecto cuando la información no venga completa.

## Reglas de negocio
- El usuario debe incluir nombre completo.
- El correo electrónico debe ser válido y obligatorio.
- Si no se indica rol o estado, se asigna un valor por defecto.

## Métodos
- validarEmail()
- validarUsuario()
- obtenerEstadoUsuario()
