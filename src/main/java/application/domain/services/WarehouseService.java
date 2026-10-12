package application.domain.services;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import java.util.ArrayList;
import java.util.List;

public class WarehouseService {

    public Warehouse register(Warehouse warehouse) {
        validate(warehouse);
        if (warehouse.getType() == null) {
            warehouse.setType(WarehouseType.SELLER);
        }
        return warehouse;
    }

    public Warehouse classify(Warehouse warehouse, WarehouseType type) {
        validate(warehouse);
        if (type == null) {
            throw new IllegalArgumentException("Warehouse type is required.");
        }
        warehouse.setType(type);
        return warehouse;
    }

    public List<Warehouse> findBySeller(Seller seller) {
        if (seller == null || seller.getAssociatedWarehouses() == null) {
            return new ArrayList<>();
        }
        return List.copyOf(seller.getAssociatedWarehouses());
    }

    private void validate(Warehouse warehouse) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (warehouse.getName() == null || warehouse.getName().isBlank()) {
            throw new IllegalArgumentException("Warehouse name is required.");
        }
        if (warehouse.getLocation() == null || warehouse.getLocation().isBlank()) {
            throw new IllegalArgumentException("Warehouse location is required.");
        }
    }
}
