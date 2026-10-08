package application.domain.exceptions;

public class ProductValidationException extends DomainViolationException {
    public ProductValidationException(String message) {
        super(message);
    }
}
