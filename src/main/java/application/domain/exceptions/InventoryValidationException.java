package application.domain.exceptions;

public class InventoryValidationException extends DomainViolationException {
    public InventoryValidationException(String message) {
        super(message);
    }
}
