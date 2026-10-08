# MARKER

MARKER es un backend de marketplace para NexusMarket, diseñado con una arquitectura orientada al dominio y una separación clara entre reglas de negocio, casos de uso, adaptadores e infraestructura.

## Propósito del sistema

MARKER modela la operación de un marketplace con:
- usuarios, compradores y vendedores
- productos, variantes y catálogo
- inventario y bodegas
- carrito, pedidos y pagos
- facturación, logística y entregas
- devoluciones y reembolsos
- reportes y validaciones administrativas

## Arquitectura base

La solución sigue la secuencia:

1. Especificación funcional y reglas de negocio
2. Dominio del negocio
3. Servicios de dominio
4. Puertos de entrada y salida
5. Casos de uso
6. Adaptadores de persistencia y REST
7. Infraestructura y configuración
8. Pruebas y validación

Esta separación permite que el dominio permanezca desacoplado de Spring, JPA, HTTP y cualquier tecnología de infraestructura.

## Estructura del repositorio

- `SDD/` — especificación funcional, reglas del negocio y trazabilidad
- `src/main/java/application/domain/` — entidades, enums, modelos, value objects, excepciones, servicios y puertos del dominio
- `src/main/java/application/adapters/` — adaptadores, mappers y casos de uso
- `src/main/java/application/infrastructure/` — configuración, seguridad, persistencia y componentes técnicos
- `src/main/java/application/api/` — exposición REST
- `src/test/java/` — pruebas unitarias e integración

## Principios de diseño aplicados

- El dominio no depende de Spring, JPA ni HTTP.
- Los servicios del dominio encapsulan reglas de negocio y validaciones.
- Los puertos definen contratos explícitos entre dominio e infraestructura.
- Los casos de uso coordinan flujos sin mezclar lógica de negocio con almacenamiento o HTTP.
- No se duplican servicios ni capas con responsabilidades equivalentes.
- La documentación y la implementación deben mantenerse sincronizadas.

## Organización del dominio

La capa de dominio está reservada para:
- entidades del negocio
- enums de estados y tipos
- objetos de valor con validación propia
- excepciones de negocio
- servicios de dominio con responsabilidad específica
- puertos de entrada y salida

Los servicios de dominio no son componentes Spring. Son clases puras del negocio que reciben datos y devuelven resultados o lanzan excepciones del dominio.

## Organización de adaptadores e infraestructura

La infraestructura y los adaptadores se encargan de:
- persistencia
- repositorios
- entidades JPA/mappers
- DTOs, requests y responses
- controladores REST
- seguridad y autenticación
- configuración general del sistema

Esto asegura que la lógica del negocio permanezca aislada y reutilizable.

## Tecnologías

- Java 17
- Maven
- Spring Boot 4.1.1
- Spring Data JPA
- H2 para entorno local
- Docker Compose
- Lombok

## Cómo ejecutar

1. Clonar el repositorio.
2. Ejecutar:

```bash
./mvnw clean install
```

3. Iniciar la aplicación:

```bash
./mvnw spring-boot:run
```

4. Opcionalmente, levantar infraestructura con Docker:

```bash
docker-compose up --build
```

## Cómo probar

```bash
./mvnw test
```

## Estado del proyecto

La estructura actual ha sido ajustada para mantener el dominio limpio, eliminar duplicidades innecesarias y reforzar la separación entre negocio e infraestructura. El proyecto sigue siendo compatible con Java y Maven, y la documentación se mantiene alineada con ese principio arquitectónico.
