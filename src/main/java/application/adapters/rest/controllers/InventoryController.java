package application.adapters.rest.controllers;

import application.adapters.rest.dtos.inventory.InventoryRequest;
import application.adapters.rest.dtos.inventory.InventoryResponse;
import application.adapters.rest.mappers.InventoryRestMapper;
import application.domain.entities.Inventory;
import application.domain.ports.in.ManageInventoryUseCase;
import application.domain.ports.in.ReserveInventoryUseCase;
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
    private final ReserveInventoryUseCase reserveInventoryUseCase;

    public InventoryController(
            ManageInventoryUseCase manageInventoryUseCase,
            ReserveInventoryUseCase reserveInventoryUseCase) {
        this.manageInventoryUseCase = manageInventoryUseCase;
        this.reserveInventoryUseCase = reserveInventoryUseCase;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryResponse> getByProductId(@PathVariable Long productId) {
        Optional<Inventory> inventory = manageInventoryUseCase.findByProductId(productId);
        return inventory.map(InventoryRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InventoryResponse save(@RequestBody InventoryRequest request) {
        return InventoryRestMapper.toResponse(
                manageInventoryUseCase.save(InventoryRestMapper.toDomain(request)));
    }

    @PostMapping("/{inventoryId}/reserve")
    public InventoryResponse reserve(
            @PathVariable Long inventoryId,
            @RequestBody ReservationRequest request) {
        return InventoryRestMapper.toResponse(
                reserveInventoryUseCase.reserve(inventoryId, request.quantity()));
    }

    public record ReservationRequest(int quantity) {}
}
