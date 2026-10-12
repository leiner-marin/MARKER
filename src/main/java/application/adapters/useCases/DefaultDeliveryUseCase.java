package application.adapters.useCases;

import application.domain.entities.Shipment;
import application.domain.ports.in.ConfirmDeliveryUseCase;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.services.DeliveryService;

public class DefaultDeliveryUseCase implements ConfirmDeliveryUseCase {
    private final ShipmentRepositoryPort shipmentRepositoryPort;
    private final DeliveryService deliveryService;

    public DefaultDeliveryUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            DeliveryService deliveryService) {
        this.shipmentRepositoryPort = shipmentRepositoryPort;
        this.deliveryService = deliveryService;
    }

    @Override
    public Shipment confirm(Shipment shipment) {
        if (shipment == null || shipment.getId() == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        Shipment current = shipmentRepositoryPort.findById(shipment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));
        return shipmentRepositoryPort.update(deliveryService.confirm(current));
    }
}
