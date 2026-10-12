package application.adapters.rest.controllers;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.ports.in.ManageSellerUseCase;
import application.domain.ports.in.OnboardSellerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    private final OnboardSellerUseCase onboardSellerUseCase;
    private final ManageSellerUseCase manageSellerUseCase;

    public SellerController(OnboardSellerUseCase onboardSellerUseCase, ManageSellerUseCase manageSellerUseCase) {
        this.onboardSellerUseCase = onboardSellerUseCase;
        this.manageSellerUseCase = manageSellerUseCase;
    }

    @PostMapping
    public ResponseEntity<Seller> onboard(@RequestBody Seller seller) {
        return ResponseEntity.ok(onboardSellerUseCase.onboard(seller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findById(@PathVariable Long id) {
        return ResponseEntity.ok(manageSellerUseCase.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller seller) {
        seller.setId(id);
        return ResponseEntity.ok(manageSellerUseCase.update(seller));
    }

    @PostMapping("/assign-warehouse")
    public ResponseEntity<Seller> assignWarehouse(@RequestBody SellerWarehouseRequest request) {
        return ResponseEntity.ok(onboardSellerUseCase.assignWarehouse(request.seller(), request.warehouse()));
    }

    public record SellerWarehouseRequest(Seller seller, Warehouse warehouse) {}
}
