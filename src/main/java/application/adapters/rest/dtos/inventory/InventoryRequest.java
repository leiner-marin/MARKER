package application.adapters.rest.dtos.inventory;

public record InventoryRequest(
        Long productId,
        Long warehouseId,
        Integer availableQuantity) {
}
