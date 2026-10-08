package application.api;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    private final VendedorService vendedorService;

    public SellerController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping("/register")
    public ResponseEntity<Seller> register(@RequestBody Seller seller) {
        try {
            Seller registered = vendedorService.registerSeller(seller, null);
            return ResponseEntity.ok(registered);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/assign-warehouse")
    public ResponseEntity<Seller> assignWarehouse(@RequestBody SellerWarehouseRequest request) {
        try {
            Seller updated = vendedorService.assignWarehouse(request.getSeller(), request.getWarehouse());
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    public static class SellerWarehouseRequest {
        private Seller seller;
        private Warehouse warehouse;

        public Seller getSeller() {
            return seller;
        }

        public void setSeller(Seller seller) {
            this.seller = seller;
        }

        public Warehouse getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(Warehouse warehouse) {
            this.warehouse = warehouse;
        }
    }
}
