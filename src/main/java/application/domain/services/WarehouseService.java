package application.domain.services;

import application.domain.models.Seller;
import application.domain.models.Warehouse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

    public Warehouse registerWarehouse(Warehouse warehouse) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (warehouse.getType() == null || warehouse.getType().isBlank()) {
            warehouse.setType("SELLER");
        }
        return warehouse;
    }

    public Warehouse classifyWarehouse(Warehouse warehouse, String type) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Warehouse type is required.");
        }
        warehouse.setType(type);
        return warehouse;
    }

    public List<Warehouse> getWarehousesForSeller(Seller seller) {
        if (seller == null || seller.getAssociatedWarehouses() == null) {
            return new ArrayList<>();
        }
        return seller.getAssociatedWarehouses();
    }
}
