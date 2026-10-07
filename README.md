# MARKER

## Descripción
MARKER es una plataforma de comercio electrónico orientada a marketplace, con foco en usuarios, vendedores, productos, inventario, pedidos, pagos, logística y reportes administrativos.

## Objetivo
Centralizar la gestión del catálogo, la operación comercial y la logística de ventas para un ecosistema con compradores, vendedores y administradores.

## Funcionalidades
- Registro y administración de usuarios, compradores y vendedores.
- Gestión de bodegas, productos, variantes y catálogo.
- Control de inventario con reservas, ajustes y movimientos.
- Gestión de carrito, pedidos, pagos y facturación.
- Preparación, despacho, entrega y devolución de pedidos.
- Generación de reportes administrativos.

## Arquitectura
El proyecto sigue un enfoque basado en dominio, con separación entre:
- dominio: entidades, enums, excepciones, puertos y servicios.
- adaptadores: casos de uso, REST y persistencia.
- infraestructura: configuración, seguridad y servicios transversales.

## Estructura
- `SDD/` contiene la especificación de negocio y la documentación del dominio.
- `src/main/java/application/` contiene la implementación del backend.
- `src/test/java/application/` está reservado para pruebas unitarias e integradas.

## Tecnologías
- Java 24
- Spring Boot 4.1.1
- Spring Data JPA
- H2 en memoria para desarrollo
- Maven
- Docker Compose para entorno de infraestructura

## Cómo ejecutar
1. Clonar el repositorio.
2. Ejecutar `./mvnw clean install`.
3. Iniciar la aplicación con `./mvnw spring-boot:run`.

## Cómo probar
- Ejecutar `./mvnw test`

## Reglas principales
- El dominio debe permanecer independiente de la infraestructura.
- Los servicios de dominio deben validar precondiciones y reglas del negocio.
- Los puertos de salida definen la abstracción de persistencia y servicios externos.
- Los casos de uso coordinan la ejecución de dominio y adaptadores.

## Estado del proyecto
En evolución. La estructura documental y de dominio ya ha sido reorganizada para seguir el patrón sugerido por el docente.
