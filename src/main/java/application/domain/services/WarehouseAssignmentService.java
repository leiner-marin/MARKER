package application.domain.services;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import java.util.ArrayList;

public class WarehouseAssignmentService {

    public Warehouse assign(Seller seller, Warehouse warehouse) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }

        warehouse.setOwnerSeller(seller);

        if (seller.getAssociatedWarehouses() == null) {
            seller.setAssociatedWarehouses(new ArrayList<>());
        }

        if (!seller.getAssociatedWarehouses().contains(warehouse)) {
            seller.getAssociatedWarehouses().add(warehouse);
        }

        return warehouse;
    }
}
