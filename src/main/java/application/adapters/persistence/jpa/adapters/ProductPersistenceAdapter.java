package application.adapters.persistence.jpa.adapters;

import application.adapters.persistence.jpa.entities.ProductEntity;
import application.adapters.persistence.jpa.mappers.ProductJpaMapper;
import application.adapters.persistence.jpa.repositories.ProductJpaRepository;
import application.domain.entities.Product;
import application.domain.ports.out.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPersistenceAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository repository;

    public ProductPersistenceAdapter(ProductJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        validate(product);
        return ProductJpaMapper.toDomain(repository.save(ProductJpaMapper.toEntity(product)));
    }

    @Override
    public Product update(Product product) {
        validate(product);
        if (product.getId() == null) {
            throw new IllegalArgumentException("Product id is required for update.");
        }
        return ProductJpaMapper.toDomain(repository.save(ProductJpaMapper.toEntity(product)));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return id == null ? Optional.empty() : repository.findById(id).map(ProductJpaMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(ProductJpaMapper::toDomain).toList();
    }

    @Override
    public List<Product> findBySellerId(Long sellerId) {
        return sellerId == null
                ? List.of()
                : repository.findBySellerId(sellerId).stream().map(ProductJpaMapper::toDomain).toList();
    }

    private void validate(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (product.getSeller() == null || product.getSeller().getId() == null) {
            throw new IllegalArgumentException("Seller is required.");
        }
        if (product.getProductType() == null) {
            throw new IllegalArgumentException("Product type is required.");
        }
        if (product.getStatus() == null) {
            throw new IllegalArgumentException("Product status is required.");
        }
    }
}
