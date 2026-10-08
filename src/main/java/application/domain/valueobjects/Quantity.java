package application.domain.valueobjects;

public class Quantity {
    private final int value;

    public Quantity(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
