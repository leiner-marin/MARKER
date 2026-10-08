# Setup del proyecto MARKER

## Requisitos
- Java 17 o superior
- Maven Wrapper incluido
- Docker y Docker Compose
- Git

## Estructura objetivo

MARKER produce una separación clara entre capas:

```text
Especificación -> Dominio -> Puertos -> Casos de uso -> Adaptadores -> Infraestructura -> Pruebas
```

La lógica de negocio vive en `src/main/java/application/domain`, mientras que la infraestructura, persistencia y endpoints REST quedan aislados en `application/adapters`, `application/infrastructure` y `application/api`.

## Configuración local

1. Abrir la raíz del proyecto.
2. Ejecutar:

```bash
./mvnw clean install
```

3. Levantar la aplicación:

```bash
./mvnw spring-boot:run
```

## Entorno con Docker

```bash
docker-compose up --build
```

## Variables de entorno recomendadas

- `SPRING_PROFILES_ACTIVE`
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

## Verificación

- confirmar que la aplicación inicia sin errores
- revisar logs y endpoints activos
- ejecutar pruebas:

```bash
./mvnw test
```

## Reglas de desarrollo

- no mezclar lógica de negocio con controladores, repositorios ni JPA
- mantener los servicios de dominio desacoplados de infraestructura
- usar puertos para abstraer persistencia y servicios externos
- mantener una sola responsabilidad por componente
- evitar duplicidades entre `domain/services` y `application/services`
- sincronizar `SDD/` con la implementación real
