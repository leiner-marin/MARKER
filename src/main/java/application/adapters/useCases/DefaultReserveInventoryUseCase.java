package application.adapters.useCases;

import application.domain.entities.Inventory;
import application.domain.ports.in.ReserveInventoryUseCase;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.services.InventoryReservationService;

public class DefaultReserveInventoryUseCase implements ReserveInventoryUseCase {
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final InventoryReservationService reservationService;

    public DefaultReserveInventoryUseCase(
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryReservationService reservationService) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.reservationService = reservationService;
    }

    @Override
    public Inventory reserve(Long inventoryId, int quantity) {
        if (inventoryId == null) {
            throw new IllegalArgumentException("Inventory id is required.");
        }
        Inventory inventory = inventoryRepositoryPort.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found."));
        return inventoryRepositoryPort.update(reservationService.reserve(inventory, quantity));
    }
}
