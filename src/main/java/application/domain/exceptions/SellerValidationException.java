package application.domain.exceptions;

public class SellerValidationException extends DomainViolationException {
    public SellerValidationException(String message) {
        super(message);
    }
}
