package application.services;

import application.ports.out.ProductRepository;

public class ProductoService extends application.domain.services.ProductoService {

    public ProductoService(ProductRepository productRepository) {
        super(productRepository);
    }
}
