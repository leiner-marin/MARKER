package application.services;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BodegaService {

    public Warehouse registerWarehouse(Warehouse warehouse) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (warehouse.getType() == null) {
            warehouse.setType(WarehouseType.SELLER);
        }
        return warehouse;
    }

    public Warehouse classifyWarehouse(Warehouse warehouse, WarehouseType type) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        if (type == null) {
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

