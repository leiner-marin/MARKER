package application.adapters.rest.controllers;

import application.domain.entities.Shipment;
import application.domain.ports.in.ConfirmDeliveryUseCase;
import application.domain.ports.in.ManageShipmentUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ManageShipmentUseCase manageShipmentUseCase;
    private final ConfirmDeliveryUseCase confirmDeliveryUseCase;

    public ShipmentController(
            ManageShipmentUseCase manageShipmentUseCase,
            ConfirmDeliveryUseCase confirmDeliveryUseCase) {
        this.manageShipmentUseCase = manageShipmentUseCase;
        this.confirmDeliveryUseCase = confirmDeliveryUseCase;
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment shipment) {
        return manageShipmentUseCase.create(shipment);
    }

    @PutMapping("/{id}/dispatch")
    public Shipment dispatch(@PathVariable Long id, @RequestBody Shipment shipment) {
        shipment.setId(id);
        return manageShipmentUseCase.dispatch(shipment);
    }

    @PutMapping("/{id}/deliver")
    public Shipment deliver(@PathVariable Long id, @RequestBody Shipment shipment) {
        shipment.setId(id);
        return confirmDeliveryUseCase.confirm(shipment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> findById(
            @PathVariable Long id,
            @RequestBody(required = false) Shipment ignored) {
        return ResponseEntity.notFound().build();
    }
}
