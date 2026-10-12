package application.adapters.rest.controllers;

import application.adapters.rest.dtos.inventory.InventoryRequest;
import application.adapters.rest.dtos.inventory.InventoryResponse;
import application.adapters.rest.mappers.InventoryRestMapper;
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
    public ResponseEntity<InventoryResponse> getByProductId(@PathVariable Long productId) {
        Optional<application.domain.entities.Inventory> inventory =
                manageInventoryUseCase.findByProductId(productId);

        return inventory.map(InventoryRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InventoryResponse save(@RequestBody InventoryRequest request) {
        return InventoryRestMapper.toResponse(
                manageInventoryUseCase.save(InventoryRestMapper.toDomain(request)));
    }
}
