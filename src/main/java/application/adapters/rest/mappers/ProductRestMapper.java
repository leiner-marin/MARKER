package application.adapters.rest.mappers;

import application.adapters.rest.dtos.product.ProductRequest;
import application.adapters.rest.dtos.product.ProductResponse;
import application.domain.entities.Product;
import application.domain.entities.Seller;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import java.util.ArrayList;

public final class ProductRestMapper {
    private ProductRestMapper() {}

    public static Product toDomain(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setProductType(parseProductType(request.productType()));
        product.setVariants(request.variants() == null ? new ArrayList<>() : new ArrayList<>(request.variants()));

        if (request.sellerId() != null) {
            Seller seller = new Seller();
            seller.setId(request.sellerId());
            product.setSeller(seller);
        }
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        Long sellerId = product.getSeller() == null ? null : product.getSeller().getId();
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getProductType() == null ? null : product.getProductType().name(),
                product.getVariants(),
                product.getStatus() == null ? null : product.getStatus().name(),
                sellerId);
    }

    private static ProductType parseProductType(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return ProductType.valueOf(value.toUpperCase());
    }
}
