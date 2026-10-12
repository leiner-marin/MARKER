package application.adapters.rest.dtos.product;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String productType,
        List<String> variants,
        String status,
        Long sellerId) {
}
