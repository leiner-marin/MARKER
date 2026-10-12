package application.adapters.rest.dtos.buyer;

public record BuyerResponse(
        Long id,
        String fullName,
        String email,
        String primaryAddress,
        String commercialStatus) {
}
