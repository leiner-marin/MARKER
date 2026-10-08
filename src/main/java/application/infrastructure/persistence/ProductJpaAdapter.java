package application.infrastructure.persistence;

import application.domain.models.ProductModel;
import application.domain.ports.out.ProductPort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJpaAdapter implements ProductPort {
    private final ProductJpaRepository repository;

    public ProductJpaAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductModel save(ProductModel product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        ProductEntity entity = toEntity(product);
        return toModel(repository.save(entity));
    }

    @Override
    public ProductModel update(ProductModel product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (product.getId() == null) {
            throw new IllegalArgumentException("Product id is required for update.");
        }
        ProductEntity entity = toEntity(product);
        return toModel(repository.save(entity));
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        return repository.findById(id).map(this::toModel);
    }

    @Override
    public List<ProductModel> findAll() {
        return repository.findAll().stream().map(this::toModel).toList();
    }

    @Override
    public List<ProductModel> findBySellerId(Long sellerId) {
        if (sellerId == null) {
            return List.of();
        }
        return repository.findBySellerId(String.valueOf(sellerId)).stream()
            .map(this::toModel)
            .toList();
    }

    private ProductEntity toEntity(ProductModel model) {
        ProductEntity entity = new ProductEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setSellerId(model.getSellerId());
        entity.setStatus(model.getStatus());
        return entity;
    }

    private ProductModel toModel(ProductEntity entity) {
        ProductModel model = new ProductModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSellerId(entity.getSellerId());
        model.setStatus(entity.getStatus());
        return model;
    }
}
