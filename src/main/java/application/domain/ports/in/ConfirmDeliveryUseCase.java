package application.domain.ports.in;

import application.domain.entities.Shipment;

public interface ConfirmDeliveryUseCase {
    Shipment confirm(Shipment shipment);
}
