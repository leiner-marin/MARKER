package application.domain.exceptions;

public class DomainViolationException extends RuntimeException {
    public DomainViolationException(String message) {
        super(message);
    }
}
