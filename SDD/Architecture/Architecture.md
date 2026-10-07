# Architecture

## Visión general
MARKER está organizado siguiendo una arquitectura hexagonal orientada al dominio, con separación clara entre:
- dominio
- casos de uso
- adaptadores
- infraestructura

## Capa de dominio
Contiene entidades, value objects, enums, servicios y puertos.

## Capa de adaptadores
Encapsula persistencia, REST y orquestación de caso de uso.

## Capa de infraestructura
Incluye configuración, seguridad y conectores externos.
