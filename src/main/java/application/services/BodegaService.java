package application.services;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import java.util.List;

public class BodegaService extends application.domain.services.BodegaService {

    public BodegaService() {
        super();
    }

    @Override
    public Warehouse registerWarehouse(Warehouse warehouse) {
        return super.registerWarehouse(warehouse);
    }

    @Override
    public Warehouse classifyWarehouse(Warehouse warehouse, WarehouseType type) {
        return super.classifyWarehouse(warehouse, type);
    }

    @Override
    public List<Warehouse> getWarehousesForSeller(Seller seller) {
        return super.getWarehousesForSeller(seller);
    }
}
