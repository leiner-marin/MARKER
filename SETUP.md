# Setup del proyecto MARKER

## Requisitos
- Java 24+
- Maven o Maven Wrapper
- Docker y Docker Compose
- Git

## Configuración local
1. Abrir la raíz del proyecto.
2. Ejecutar `./mvnw clean install`.
3. Validar que el proyecto se levanta con `./mvnw spring-boot:run`.

## Entorno con Docker
Ejecutar:

```bash
docker-compose up --build
```

## Variables de entorno
Definir según el entorno de despliegue:
- `SPRING_PROFILES_ACTIVE`
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

## Verificación
- Verificar que la aplicación inicie sin errores.
- Revisar logs y endpoints activos.
- Ejecutar pruebas con `./mvnw test`.
