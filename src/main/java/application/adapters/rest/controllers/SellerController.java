package application.adapters.rest.controllers;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.ports.in.OnboardSellerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    private final OnboardSellerUseCase onboardSellerUseCase;

    public SellerController(OnboardSellerUseCase onboardSellerUseCase) {
        this.onboardSellerUseCase = onboardSellerUseCase;
    }

    @PostMapping
    public ResponseEntity<Seller> onboard(@RequestBody Seller seller) {
        return ResponseEntity.ok(onboardSellerUseCase.onboard(seller));
    }

    @PostMapping("/assign-warehouse")
    public ResponseEntity<Seller> assignWarehouse(@RequestBody SellerWarehouseRequest request) {
        return ResponseEntity.ok(
                onboardSellerUseCase.assignWarehouse(request.seller(), request.warehouse()));
    }

    public record SellerWarehouseRequest(Seller seller, Warehouse warehouse) {}
}
