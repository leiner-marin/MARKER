# Servicios de aplicacion

## Regla de implementacion

Cada archivo Java de esta carpeta debe contener un solo servicio Spring:

- Una sola clase publica.
- Una sola anotacion `@Service`.
- El nombre del archivo debe coincidir con la clase.
- Las operaciones propias del servicio pueden ser publicas.
- Los metodos auxiliares que no formen parte del caso de uso deben ser `private`.
- No se deben declarar otros servicios Spring dentro del mismo archivo.

Ejemplo:

```text
ProductoService.java
  @Service
  public class ProductoService { ... }
```

La carpeta puede contener varios archivos, porque cada archivo representa un servicio de negocio diferente.
