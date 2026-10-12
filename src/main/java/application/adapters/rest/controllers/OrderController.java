package application.adapters.rest.controllers;

import application.domain.entities.Buyer;
import application.domain.entities.Order;
import application.domain.ports.in.CreateOrderUseCase;
import application.domain.ports.in.ManageOrderUseCase;
import application.infrastructure.security.CurrentActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final ManageOrderUseCase manageOrderUseCase;
    private final CurrentActorService currentActorService;

    public OrderController(
            CreateOrderUseCase createOrderUseCase,
            ManageOrderUseCase manageOrderUseCase,
            CurrentActorService currentActorService) {
        this.createOrderUseCase = createOrderUseCase;
        this.manageOrderUseCase = manageOrderUseCase;
        this.currentActorService = currentActorService;
    }

    @PostMapping
    public Order create(
            @RequestBody Order order,
            Authentication authentication) {
        if (currentActorService.isBuyer(authentication)) {
            requireBuyerFromOrder(order, authentication);
        }
        return createOrderUseCase.create(order);
    }

    @PostMapping("/from-cart")
    public Order createFromCart(
            @RequestBody Buyer buyer,
            Authentication authentication) {
        requireBuyerOwner(buyer, authentication);
        return createOrderUseCase.createFromCart(buyer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok(manageOrderUseCase.findById(id));
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestBody Order order,
            Authentication authentication) {
        if (order == null) {
            throw new IllegalArgumentException("Order is required.");
        }
        if (currentActorService.isBuyer(authentication)) {
            requireBuyerFromOrder(order, authentication);
        }
        order.setId(id);
        return manageOrderUseCase.updateStatus(order);
    }

    private void requireBuyerFromOrder(Order order, Authentication authentication) {
        if (order == null || order.getBuyer() == null || order.getBuyer().getId() == null) {
            throw new IllegalArgumentException("Buyer is required for this operation.");
        }
        currentActorService.requireBuyerOwner(authentication, order.getBuyer().getId());
    }

    private void requireBuyerOwner(Buyer buyer, Authentication authentication) {
        if (buyer == null || buyer.getId() == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        currentActorService.requireBuyerOwner(authentication, buyer.getId());
    }
}
