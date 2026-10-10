package application.adapters.rest.controllers;

import application.domain.entities.Inventory;
import application.domain.ports.in.ManageInventoryUseCase;
import java.util.Optional;
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
    private final ManageInventoryUseCase manageInventoryUseCase;

    public InventoryController(ManageInventoryUseCase manageInventoryUseCase) {
        this.manageInventoryUseCase = manageInventoryUseCase;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getByProductId(@PathVariable Long productId) {
        Optional<Inventory> inventory = manageInventoryUseCase.findByProductId(productId);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventory save(@RequestBody Inventory inventory) {
        return manageInventoryUseCase.save(inventory);
    }
}
