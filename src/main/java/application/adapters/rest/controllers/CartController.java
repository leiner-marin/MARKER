package application.adapters.rest.controllers;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Product;
import application.domain.ports.in.ManageCartUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final ManageCartUseCase manageCartUseCase;

    public CartController(ManageCartUseCase manageCartUseCase) {
        this.manageCartUseCase = manageCartUseCase;
    }

    @PostMapping("/items")
    public Cart addProduct(@RequestBody CartItemRequest request) {
        return manageCartUseCase.addProduct(request.buyer(), request.product());
    }

    @DeleteMapping("/items")
    public Cart removeProduct(@RequestBody CartItemRequest request) {
        return manageCartUseCase.removeProduct(request.buyer(), request.product());
    }

    @DeleteMapping
    public Cart clear(@RequestBody Buyer buyer) {
        return manageCartUseCase.clear(buyer);
    }

    public record CartItemRequest(Buyer buyer, Product product) {}
}
