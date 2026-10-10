package application.adapters.rest.dtos.inventory;

public record InventoryResponse(
        Long id,
        Long productId,
        Long warehouseId,
        Integer availableQuantity,
        String movementType) {
}
