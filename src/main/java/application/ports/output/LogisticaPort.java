package application.ports.output;

import application.domain.entities.Shipment;
import java.util.Optional;

public interface LogisticaPort {
    Shipment crearEnvio(Shipment shipment);
    Shipment despachar(Shipment shipment);
    Optional<String> consultarEstado(String trackingNumber);
    boolean confirmarEntrega(String trackingNumber);
}
