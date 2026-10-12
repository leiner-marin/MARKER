package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.ReturnRequest;
import application.domain.ports.in.RequestReturnUseCase;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.services.ReturnService;
import java.math.BigDecimal;

public class DefaultReturnUseCase implements RequestReturnUseCase {
    private final ReturnRepositoryPort returnRepositoryPort;
    private final ReturnService returnService;

    public DefaultReturnUseCase(
            ReturnRepositoryPort returnRepositoryPort,
            ReturnService returnService) {
        this.returnRepositoryPort = returnRepositoryPort;
        this.returnService = returnService;
    }

    @Override
    public Order request(Order order) {
        if (order == null || order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order with products is required.");
        }
        Product product = order.getProducts().get(0);
        ReturnRequest request = returnService.request(order, product, "Customer return request", BigDecimal.ZERO);
        return request.getOrder();
    }
}
