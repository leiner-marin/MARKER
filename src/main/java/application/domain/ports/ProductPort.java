package application.domain.ports;

import application.domain.models.Product;
import application.domain.models.Seller;
import java.util.List;

public interface ProductPort {
    Product registerProduct(Product product);
    Product publishProduct(Product product);
    Product suspendProduct(Product product);
    Product discontinueProduct(Product product);
    List<Product> getCatalog(Seller seller);
}
