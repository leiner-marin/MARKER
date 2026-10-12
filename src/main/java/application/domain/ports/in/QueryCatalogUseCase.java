package application.domain.ports.in;

import application.domain.entities.Product;
import java.util.List;

public interface QueryCatalogUseCase {
    List<Product> getPublishedProducts();
}
