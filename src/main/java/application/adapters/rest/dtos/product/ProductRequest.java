package application.adapters.rest.dtos.product;

import java.util.List;

public record ProductRequest(
        String name,
        String productType,
        List<String> variants,
        Long sellerId) {
}
