package application.api;

import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import application.domain.services.BodegaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final BodegaService bodegaService;

    public WarehouseController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @PostMapping
    public ResponseEntity<Warehouse> register(@RequestBody Warehouse warehouse) {
        try {
            Warehouse registered = bodegaService.registerWarehouse(warehouse);
            return ResponseEntity.ok(registered);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/classify")
    public ResponseEntity<Warehouse> classify(@RequestBody WarehouseClassificationRequest request) {
        try {
            Warehouse updated = bodegaService.classifyWarehouse(request.getWarehouse(), request.getType());
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    public static class WarehouseClassificationRequest {
        private Warehouse warehouse;
        private WarehouseType type;

        public Warehouse getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(Warehouse warehouse) {
            this.warehouse = warehouse;
        }

        public WarehouseType getType() {
            return type;
        }

        public void setType(WarehouseType type) {
            this.type = type;
        }
    }
}
