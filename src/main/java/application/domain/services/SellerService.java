package application.domain.services;

import application.domain.models.Administrator;
import application.domain.models.Seller;
import application.domain.models.Warehouse;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    public Seller registerSeller(Seller seller, Administrator administrator) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (administrator == null) {
            throw new IllegalArgumentException("An administrator is required to register the seller.");
        }
        if (seller.getSellerStatus() == null || seller.getSellerStatus().isBlank()) {
            seller.setSellerStatus("ACTIVE");
        }
        return seller;
    }

    public Seller assignWarehouse(Seller seller, Warehouse warehouse) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (seller.getAssociatedWarehouses() == null) {
            seller.setAssociatedWarehouses(new ArrayList<>());
        }
        if (!seller.getAssociatedWarehouses().contains(warehouse)) {
            seller.getAssociatedWarehouses().add(warehouse);
        }
        return seller;
    }

    public Seller updateSellerName(Seller seller, String newName) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        seller.setFullName(newName);
        return seller;
    }
}
