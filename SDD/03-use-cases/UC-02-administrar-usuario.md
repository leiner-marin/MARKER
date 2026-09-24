# UC-02 Administrar usuario

## Actor principal
Administrador

## Objetivo
Actualizar, consultar y bloquear o activar usuarios del sistema.

## Precondiciones
- El administrador debe estar autenticado.
- El usuario objetivo debe existir.

## Flujo principal
1. El administrador solicita la gestión de un usuario.
2. El sistema valida el rol del administrador.
3. El sistema consulta o actualiza los datos del usuario.
4. El sistema cambia el estado si aplica.
5. El sistema confirma la operación.

## Postcondiciones
- El estado o datos del usuario quedan actualizados.

## Servicios involucrados
- UsuarioService

## Puertos de salida
- UsuarioRepository
