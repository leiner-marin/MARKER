package application.adapters.persistence.jpa.mappers;

import application.adapters.persistence.jpa.entities.InventoryEntity;
import application.domain.entities.Inventory;
import application.domain.entities.Product;
import application.domain.entities.Warehouse;

public final class InventoryJpaMapper {
    private InventoryJpaMapper() {}

    public static InventoryEntity toEntity(Inventory inventory) {
        InventoryEntity entity = new InventoryEntity();
        entity.setId(inventory.getId());
        entity.setProductId(inventory.getProduct().getId());
        entity.setWarehouseId(inventory.getWarehouse().getId());
        entity.setAvailableQuantity(inventory.getAvailableQuantity());
        entity.setReservedQuantity(0);
        entity.setMovementType(parseMovementType(inventory.getMovementType()));
        return entity;
    }

    public static Inventory toDomain(InventoryEntity entity) {
        Inventory inventory = new Inventory();
        inventory.setId(entity.getId());
        inventory.setAvailableQuantity(entity.getAvailableQuantity());
        inventory.setMovementType(entity.getMovementType() == null ? null : entity.getMovementType().name());

        Product product = new Product();
        product.setId(entity.getProductId());
        inventory.setProduct(product);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(entity.getWarehouseId());
        inventory.setWarehouse(warehouse);
        return inventory;
    }

    private static application.domain.enums.InventoryMovementType parseMovementType(String value) {
        if (value == null || value.isBlank()) {
            return application.domain.enums.InventoryMovementType.INGRESS;
        }
        return application.domain.enums.InventoryMovementType.valueOf(value);
    }
}
