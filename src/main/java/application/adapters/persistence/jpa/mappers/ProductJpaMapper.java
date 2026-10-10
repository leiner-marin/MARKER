package application.adapters.persistence.jpa.mappers;

import application.adapters.persistence.jpa.entities.ProductEntity;
import application.domain.entities.Product;

public final class ProductJpaMapper {
    private ProductJpaMapper() {}

    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setSellerId(product.getSeller().getId());
        entity.setProductType(product.getProductType());
        entity.setVariants(product.getVariants());
        entity.setStatus(product.getStatus());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setProductType(entity.getProductType());
        product.setVariants(entity.getVariants());
        product.setStatus(entity.getStatus());

        application.domain.entities.Seller seller = new application.domain.entities.Seller();
        seller.setId(entity.getSellerId());
        product.setSeller(seller);
        return product;
    }
}
