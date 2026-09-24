# UC-04 Registrar vendedor

## Actor principal
Administrador

## Objetivo
Registrar un vendedor dentro del marketplace.

## Precondiciones
- El administrador debe estar autenticado.
- El vendedor no debe estar ya registrado.

## Flujo principal
1. El administrador solicita crear un vendedor.
2. El sistema valida los datos del vendedor.
3. El sistema crea la entidad vendedor.
4. El sistema guarda la información de estado.
5. El sistema confirma la creación.

## Postcondiciones
- El vendedor queda registrado y puede iniciar operación comercial.

## Servicios involucrados
- VendedorService

## Puertos de salida
- VendedorRepository
