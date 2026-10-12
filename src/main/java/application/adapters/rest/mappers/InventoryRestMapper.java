package application.adapters.rest.mappers;

import application.adapters.rest.dtos.inventory.InventoryRequest;
import application.adapters.rest.dtos.inventory.InventoryResponse;
import application.domain.entities.Inventory;
import application.domain.entities.Product;
import application.domain.entities.Warehouse;
import java.time.format.DateTimeFormatter;

public final class InventoryRestMapper {
    private InventoryRestMapper() {}

    public static Inventory toDomain(InventoryRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Inventory request is required.");
        }
        Inventory inventory = new Inventory();

        Product product = new Product();
        product.setId(request.productId());
        inventory.setProduct(product);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(request.warehouseId());
        inventory.setWarehouse(warehouse);

        inventory.setAvailableQuantity(request.availableQuantity());
        inventory.setDamaged(request.damaged());
        return inventory;
    }

    public static InventoryResponse toResponse(Inventory inventory) {
        Long productId = inventory.getProduct() == null ? null : inventory.getProduct().getId();
        Long warehouseId = inventory.getWarehouse() == null ? null : inventory.getWarehouse().getId();
        String movementDate = inventory.getMovementDate() == null
                ? null
                : inventory.getMovementDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return new InventoryResponse(
                inventory.getId(),
                productId,
                warehouseId,
                inventory.getAvailableQuantity(),
                inventory.getReservedQuantity(),
                inventory.isDamaged(),
                inventory.getMovementType(),
                movementDate);
    }
}
