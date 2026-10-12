package application.adapters.rest.controllers;

import application.domain.entities.Order;
import application.domain.ports.in.CreateOrderUseCase;
import application.domain.ports.in.ManageOrderUseCase;
import org.springframework.http.ResponseEntity;
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

    public OrderController(
            CreateOrderUseCase createOrderUseCase,
            ManageOrderUseCase manageOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.manageOrderUseCase = manageOrderUseCase;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return createOrderUseCase.create(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok(manageOrderUseCase.findById(id));
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestBody Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order is required.");
        }
        order.setId(id);
        return manageOrderUseCase.updateStatus(order);
    }
}
