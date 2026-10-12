package application.adapters.rest.dtos.buyer;

public record BuyerRequest(
        String fullName,
        String email,
        String primaryAddress,
        String commercialStatus) {
}
