package application.adapters.rest.mappers;

import application.adapters.rest.dtos.inventory.InventoryRequest;
import application.adapters.rest.dtos.inventory.InventoryResponse;
import application.domain.entities.Inventory;
import application.domain.entities.Product;
import application.domain.entities.Warehouse;

public final class InventoryRestMapper {
    private InventoryRestMapper() {}

    public static Inventory toDomain(InventoryRequest request) {
        Inventory inventory = new Inventory();

        Product product = new Product();
        product.setId(request.productId());
        inventory.setProduct(product);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(request.warehouseId());
        inventory.setWarehouse(warehouse);

        inventory.setAvailableQuantity(request.availableQuantity());
        return inventory;
    }

    public static InventoryResponse toResponse(Inventory inventory) {
        Long productId = inventory.getProduct() == null ? null : inventory.getProduct().getId();
        Long warehouseId = inventory.getWarehouse() == null ? null : inventory.getWarehouse().getId();

        return new InventoryResponse(
                inventory.getId(),
                productId,
                warehouseId,
                inventory.getAvailableQuantity(),
                inventory.getMovementType());
    }
}
