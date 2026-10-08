package application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import application.domain.services.BodegaService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BodegaServiceTest {
    private final BodegaService service = new BodegaService();

    @Test
    void registersWarehouseAndDefaultsType() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("Bodega Norte");

        Warehouse saved = service.registerWarehouse(warehouse);

        assertNotNull(saved);
        assertEquals(WarehouseType.SELLER, saved.getType());
    }

    @Test
    void classifiesWarehouseWhenTypeIsProvided() {
        Warehouse warehouse = new Warehouse();

        Warehouse updated = service.classifyWarehouse(warehouse, WarehouseType.MARKETPLACE);

        assertEquals(WarehouseType.MARKETPLACE, updated.getType());
    }

    @Test
    void returnsAssociatedWarehousesForSeller() {
        Seller seller = new Seller();
        Warehouse warehouseOne = new Warehouse();
        Warehouse warehouseTwo = new Warehouse();
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouseOne);
        warehouses.add(warehouseTwo);
        seller.setAssociatedWarehouses(warehouses);

        List<Warehouse> result = service.getWarehousesForSeller(seller);

        assertEquals(2, result.size());
    }

    @Test
    void rejectsNullWarehouse() {
        assertThrows(IllegalArgumentException.class, () -> service.registerWarehouse(null));
        assertThrows(IllegalArgumentException.class, () -> service.classifyWarehouse(null, WarehouseType.SELLER));
    }
}
