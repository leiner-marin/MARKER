# UC-01 Registrar usuario

## Actor principal
Usuario

## Objetivo
Registrar un nuevo usuario dentro del sistema.

## Precondiciones
- El usuario no debe existir previamente.
- La información mínima debe estar completa.

## Flujo principal
1. El usuario solicita registrarse.
2. El sistema valida los datos obligatorios.
3. El sistema asigna el rol y estado inicial.
4. El sistema guarda el usuario.
5. El sistema confirma la creación.

## Postcondiciones
- El usuario queda registrado con estado activo o inicial válido.

## Servicios involucrados
- UsuarioService

## Puertos de salida
- UsuarioRepository
