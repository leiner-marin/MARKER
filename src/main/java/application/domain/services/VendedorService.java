package application.domain.services;

import application.domain.entities.Administrator;
import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.SellerStatus;
import java.util.ArrayList;

public class VendedorService {

    public Seller registerSeller(Seller seller) {
        return registerSeller(seller, null);
    }

    public Seller registerSeller(Seller seller, Administrator administrator) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (seller.getFullName() == null || seller.getFullName().isBlank()) {
            throw new IllegalArgumentException("Seller full name is required.");
        }
        if (seller.getEmail() == null || seller.getEmail().isBlank()) {
            throw new IllegalArgumentException("Seller email is required.");
        }
        if (administrator != null && administrator.getId() == null) {
            throw new IllegalArgumentException("Administrator must be valid.");
        }
        if (seller.getSellerStatus() == null) {
            seller.setSellerStatus(SellerStatus.ACTIVE);
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

