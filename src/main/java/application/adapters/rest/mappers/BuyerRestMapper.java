package application.adapters.rest.mappers;

import application.adapters.rest.dtos.buyer.BuyerRequest;
import application.adapters.rest.dtos.buyer.BuyerResponse;
import application.domain.entities.Buyer;
import application.domain.enums.CommercialStatus;
import java.util.ArrayList;
import java.util.List;

public final class BuyerRestMapper {
    private BuyerRestMapper() {}

    public static Buyer toDomain(BuyerRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Buyer request is required.");
        }
        Buyer buyer = new Buyer();
        buyer.setIdentityDocument(request.identityDocument());
        buyer.setFullName(request.fullName());
        buyer.setEmail(request.email());
        buyer.setPrimaryAddress(request.primaryAddress());
        buyer.setAdditionalAddresses(
                request.additionalAddresses() == null
                        ? new ArrayList<>()
                        : new ArrayList<>(request.additionalAddresses()));

        if (request.commercialStatus() != null && !request.commercialStatus().isBlank()) {
            buyer.setCommercialStatus(CommercialStatus.valueOf(request.commercialStatus().toUpperCase()));
        }
        return buyer;
    }

    public static BuyerResponse toResponse(Buyer buyer) {
        return new BuyerResponse(
                buyer.getId(),
                buyer.getIdentityDocument(),
                buyer.getFullName(),
                buyer.getEmail(),
                buyer.getPrimaryAddress(),
                buyer.getAdditionalAddresses() == null
                        ? List.of()
                        : List.copyOf(buyer.getAdditionalAddresses()),
                buyer.getCommercialStatus() == null ? null : buyer.getCommercialStatus().name());
    }
}
