package application.adapters.useCases;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.WarehouseType;
import application.domain.ports.in.ManageWarehouseUseCase;
import application.domain.ports.out.WarehouseRepositoryPort;
import application.domain.services.WarehouseService;
import java.util.List;

public class DefaultWarehouseUseCase implements ManageWarehouseUseCase {
    private final WarehouseRepositoryPort warehouseRepositoryPort;
    private final WarehouseService warehouseService;

    public DefaultWarehouseUseCase(
            WarehouseRepositoryPort warehouseRepositoryPort,
            WarehouseService warehouseService) {
        this.warehouseRepositoryPort = warehouseRepositoryPort;
        this.warehouseService = warehouseService;
    }

    @Override
    public Warehouse register(Warehouse warehouse) {
        return warehouseRepositoryPort.save(warehouseService.register(warehouse));
    }

    @Override
    public Warehouse classify(Warehouse warehouse, WarehouseType type) {
        return warehouseRepositoryPort.update(warehouseService.classify(warehouse, type));
    }

    @Override
    public List<Warehouse> findBySeller(Seller seller) {
        if (seller == null || seller.getId() == null) {
            return warehouseService.findBySeller(seller);
        }
        return warehouseRepositoryPort.findBySellerId(seller.getId());
    }
}
