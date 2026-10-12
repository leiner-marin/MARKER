package application.adapters.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.adapters.persistence.InMemoryCartRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import application.domain.services.OrderService;
import org.junit.jupiter.api.Test;

class DefaultOrderUseCaseTest {

    @Test
    void createsOrderFromCartAndClearsCart() {
        InMemoryCartRepositoryAdapter cartRepository = new InMemoryCartRepositoryAdapter();
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(10L);
        product.setName("Digital Guide");
        product.setProductType(ProductType.DIGITAL);
        product.setStatus(ProductStatus.PUBLISHED);

        Cart cart = new Cart();
        cart.setBuyer(buyer);
        cart.getProducts().add(product);
        cartRepository.save(cart);

        DefaultOrderUseCase useCase = new DefaultOrderUseCase(
                orderRepository,
                cartRepository,
                new OrderService());

        Order order = useCase.createFromCart(buyer);

        assertEquals(OrderStatus.CART, order.getStatus());
        assertEquals(1, order.getProducts().size());
        assertEquals(0, cartRepository.findByBuyer(buyer).orElseThrow().getProducts().size());
    }
}
