package application.adapters.useCases;

import application.domain.entities.Shipment;
import application.domain.ports.in.ManageShipmentUseCase;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.services.ShipmentService;

public class DefaultShipmentUseCase implements ManageShipmentUseCase {
    private final ShipmentRepositoryPort shipmentRepositoryPort;
    private final ShipmentService shipmentService;

    public DefaultShipmentUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            ShipmentService shipmentService) {
        this.shipmentRepositoryPort = shipmentRepositoryPort;
        this.shipmentService = shipmentService;
    }

    @Override
    public Shipment create(Shipment shipment) {
        return shipmentRepositoryPort.save(shipmentService.create(shipment));
    }

    @Override
    public Shipment findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        return shipmentRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));
    }

    @Override
    public Shipment dispatch(Shipment shipment) {
        if (shipment == null || shipment.getId() == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        Shipment current = shipmentRepositoryPort.findById(shipment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));
        return shipmentRepositoryPort.update(shipmentService.dispatch(current));
    }
}
