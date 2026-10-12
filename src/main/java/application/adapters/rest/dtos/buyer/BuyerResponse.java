package application.adapters.rest.dtos.buyer;

import java.util.List;

public record BuyerResponse(
        Long id,
        String fullName,
        String email,
        String primaryAddress,
        List<String> additionalAddresses,
        String commercialStatus) {
}
