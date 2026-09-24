package application.ports.output;

import java.util.Map;

public interface ReportePort {
    Map<String, Object> obtenerVentas();
    Map<String, Object> obtenerInventario();
    Map<String, Object> obtenerPedidos();
    Map<String, Object> obtenerEnvios();
}
