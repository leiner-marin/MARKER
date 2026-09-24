# UC-03 Registrar comprador

## Actor principal
Comprador

## Objetivo
Registrar la información comercial de un comprador.

## Precondiciones
- El usuario debe existir.
- El comprador debe contar con datos de dirección y estado comercial.

## Flujo principal
1. El comprador solicita registrarse como comprador.
2. El sistema valida su identidad y datos obligatorios.
3. El sistema crea la entidad Comprador.
4. El sistema asocia la información de dirección.
5. El sistema confirma el registro.

## Postcondiciones
- El comprador queda habilitado para operar en el marketplace.

## Servicios involucrados
- CompradorService

## Puertos de salida
- CompradorRepository
