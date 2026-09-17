package application.domain.ports;

import application.domain.models.Seller;
import application.domain.models.Warehouse;
import java.util.List;

public interface WarehousePort {
    Warehouse registerWarehouse(Warehouse warehouse);
    Warehouse classifyWarehouse(Warehouse warehouse, String type);
    List<Warehouse> getWarehousesForSeller(Seller seller);
}
