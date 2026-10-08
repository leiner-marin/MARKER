package application.domain.services;

import application.domain.entities.Product;
import application.domain.entities.Seller;
import java.util.ArrayList;
import java.util.List;

public class CatalogoService {

    public Seller agregarProductoCatalogo(Seller seller, Product product) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (seller.getProductCatalog() == null) {
            seller.setProductCatalog(new ArrayList<>());
        }
        if (!seller.getProductCatalog().contains(product)) {
            seller.getProductCatalog().add(product);
        }
        product.setSeller(seller);
        return seller;
    }

    public List<Product> obtenerCatalogo(Seller seller) {
        if (seller == null || seller.getProductCatalog() == null) {
            return new ArrayList<>();
        }
        return seller.getProductCatalog();
    }
}
