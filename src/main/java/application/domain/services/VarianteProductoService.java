package application.domain.services;

import application.domain.entities.Product;
import java.util.ArrayList;
import java.util.List;

public class VarianteProductoService {

    public Product asignarVariantes(Product product, List<String> variantes) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (variantes == null) {
            product.setVariants(new ArrayList<>());
            return product;
        }
        product.setVariants(variantes);
        return product;
    }

    public Product agregarVariante(Product product, String variante) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (variante == null || variante.isBlank()) {
            throw new IllegalArgumentException("Variant value is required.");
        }
        if (product.getVariants() == null) {
            product.setVariants(new ArrayList<>());
        }
        product.getVariants().add(variante);
        return product;
    }
}
