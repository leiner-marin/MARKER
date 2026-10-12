package application.infrastructure.external;

import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import application.domain.ports.out.LogisticsPort;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class InMemoryLogisticsAdapter implements LogisticsPort {
    @Override
    public Shipment create(Shipment shipment) {
        return shipment;
    }

    @Override
    public Shipment dispatch(Shipment shipment) {
        shipment.setShipmentStatus(ShipmentStatus.DISPATCHED);
        return shipment;
    }

    @Override
    public Optional<String> getStatus(String trackingNumber) {
        return trackingNumber == null || trackingNumber.isBlank()
                ? Optional.empty()
                : Optional.of("DISPATCHED");
    }

    @Override
    public boolean confirmDelivery(String trackingNumber) {
        return trackingNumber != null && !trackingNumber.isBlank();
    }
}
