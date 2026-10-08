package application.domain.ports.in;

import application.domain.models.InventoryModel;

public interface InventoryValidationUseCase {
    InventoryModel validateAndAdjust(InventoryModel inventory, int delta);
}
