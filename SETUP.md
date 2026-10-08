# Setup del proyecto MARKER

## Requisitos
- Java 17 o superior
- Maven Wrapper incluido
- Docker y Docker Compose
- Git

## Estructura objetivo

MARKER está organizado para seguir la cadena completa:

```text
Especificación -> Dominio -> Servicios -> Puertos -> Casos de uso -> Adaptadores -> Infraestructura -> Pruebas
```

Esto implica que la lógica del negocio vive en `application/domain`, mientras que la infraestructura y la exposición HTTP quedan aisladas en `application/adapters` e `application/infrastructure`.

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

Ejecutar:

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

- no mezclar lógica de negocio con controladores ni repositorios
- mantener los servicios de dominio desacoplados de infraestructura
- usar puertos para abstraer persistencia y servicios externos
- dejar los casos de uso como orquestadores del flujo y no como repositorios de negocio
- mantener la documentación en `SDD/` sincronizada con la implementación
