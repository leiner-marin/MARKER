package application.adapters.rest.controllers;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import application.domain.ports.in.ManageWarehouseUseCase;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final ManageWarehouseUseCase manageWarehouseUseCase;

    public WarehouseController(ManageWarehouseUseCase manageWarehouseUseCase) {
        this.manageWarehouseUseCase = manageWarehouseUseCase;
    }

    @PostMapping
    public ResponseEntity<Warehouse> register(@RequestBody Warehouse warehouse) {
        return ResponseEntity.ok(manageWarehouseUseCase.register(warehouse));
    }

    @PostMapping("/classify")
    public ResponseEntity<Warehouse> classify(@RequestBody WarehouseClassificationRequest request) {
        return ResponseEntity.ok(
                manageWarehouseUseCase.classify(request.warehouse(), request.type()));
    }

    @GetMapping("/seller")
    public List<Warehouse> findBySeller(@RequestBody Seller seller) {
        return manageWarehouseUseCase.findBySeller(seller);
    }

    public record WarehouseClassificationRequest(Warehouse warehouse, WarehouseType type) {}
}
