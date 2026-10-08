package application.api;

import application.domain.models.InventoryModel;
import application.domain.ports.out.InventoryPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryPort inventoryPort;

    public InventoryController(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryModel> getByProductId(@PathVariable Long productId) {
        return inventoryPort.findByProductId(productId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InventoryModel save(@RequestBody InventoryModel inventory) {
        return inventoryPort.save(inventory);
    }
}
