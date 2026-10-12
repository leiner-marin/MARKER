package application.adapters.rest.dtos.buyer;

import java.util.List;

public record BuyerRequest(
        String identityDocument,
        String fullName,
        String email,
        String primaryAddress,
        List<String> additionalAddresses,
        String commercialStatus) {
}
