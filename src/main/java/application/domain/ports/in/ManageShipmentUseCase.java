package application.domain.ports.in;

import application.domain.entities.Shipment;

public interface ManageShipmentUseCase {
    Shipment create(Shipment shipment);
    Shipment dispatch(Shipment shipment);
}
