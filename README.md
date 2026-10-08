# MARKER

MARKER es un proyecto backend de marketplace para NexusMarket, estructurado siguiendo una arquitectura orientada al dominio y la trazabilidad de requisitos a implementación.

## Cadena de valor del proyecto

La base de la solución se organiza en esta secuencia:

1. Especificación funcional y reglas de negocio
2. Dominio del negocio
3. Servicios de dominio
4. Puertos de entrada y salida
5. Casos de uso
6. Adaptadores de persistencia y REST
7. Infraestructura y configuración
8. Pruebas y validación

Esto mantiene una separación clara entre la lógica del negocio y los detalles de infraestructura, como Spring, JPA, seguridad, HTTP o base de datos.

## Objetivo del sistema

MARKER centraliza la operación de un marketplace con:
- usuarios, compradores y vendedores
- productos, variantes e inventario
- bodegas y asignación comercial
- carrito, pedidos y pagos
- facturación, logística y devoluciones
- reportes administrativos

## Estructura profesional del repositorio

- `SDD/` — especificación documental del proyecto y trazabilidad funcional
- `src/main/java/application/domain/` — entidades, enums, modelos, value objects, excepciones, servicios y puertos del dominio
- `src/main/java/application/adapters/` — casos de uso y adaptadores de infraestructura
- `src/main/java/application/infrastructure/` — configuración, persistencia y componentes transversales
- `src/main/java/application/api/` — REST controllers para la capa de exposición
- `src/test/java/` — pruebas de dominio, integración y validación operativa

## Capas de la solución

### Dominio
La capa de dominio concentra:
- modelos de negocio
- enums del sistema
- objetos de valor
- excepciones de reglas de negocio
- servicios de dominio
- puertos de entrada y salida

### Adaptadores
Los adaptadores encapsulan:
- uso de casos de uso
- coordinación entre dominio e infraestructura
- acceso a persistencia
- endpoints REST
- mapeo de DTOs, requests y responses

### Infraestructura
La infraestructura contiene:
- configuración Spring
- repositorios JPA
- adaptadores de persistencia
- seguridad
- notificaciones
- integración con servicios externos

## Documentación de negocio y dominio

La documentación funcional del proyecto se encuentra en `SDD/` y está organizada por bloques que permiten mantener trazabilidad desde requisitos hasta implementación.

Se recomienda seguir esta ruta de trabajo:

- `SDD/Business/` — reglas, actores y trazabilidad
- `SDD/Domain/` — modelos, servicios, puertos y reglas del dominio
- `SDD/Architecture/` — visión de la arquitectura global
- `SDD/Use-Cases/` — casos de uso del sistema
- `SDD/Adapters/` — integración, REST y persistencia

## Tecnologías

- Java 17+
- Spring Boot 4.1.1
- Spring Data JPA
- H2 para ambiente local
- Maven Wrapper
- Docker Compose
- Lombok

## Cómo ejecutar

1. Clonar el repositorio.
2. Ejecutar:
   - `./mvnw clean install`
3. Levantar la aplicación:
   - `./mvnw spring-boot:run`
4. Opcional: levantar infraestructura con Docker:
   - `docker-compose up --build`

## Cómo probar

Ejecutar:

```bash
./mvnw test
```

## Principios de diseño

- El dominio no depende de Spring, JPA ni HTTP.
- Los servicios de dominio validan reglas del negocio.
- Los puertos deciden el contrato entre dominio e infraestructura.
- Los casos de uso coordinan flujo sin mezclar responsabilidades.
- La persistencia y la API son adaptadores, no parte central del negocio.

## Estado del proyecto

El proyecto ya está estructurado con una primera implementación profesional del flujo principal, con separación funcional entre dominio, puertos, casos de uso, adaptadores e infraestructura, y validación continua mediante Maven.
