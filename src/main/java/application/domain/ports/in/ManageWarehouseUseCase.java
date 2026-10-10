package application.domain.ports.in;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import java.util.List;

public interface ManageWarehouseUseCase {
    Warehouse register(Warehouse warehouse);
    Warehouse classify(Warehouse warehouse, WarehouseType type);
    List<Warehouse> findBySeller(Seller seller);
}
