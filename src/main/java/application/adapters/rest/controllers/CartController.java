package application.adapters.rest.controllers;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Product;
import application.domain.ports.in.ManageCartUseCase;
import application.infrastructure.security.CurrentActorService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final ManageCartUseCase manageCartUseCase;
    private final CurrentActorService currentActorService;

    public CartController(
            ManageCartUseCase manageCartUseCase,
            CurrentActorService currentActorService) {
        this.manageCartUseCase = manageCartUseCase;
        this.currentActorService = currentActorService;
    }

    @PostMapping("/items")
    public Cart addProduct(
            @RequestBody CartItemRequest request,
            Authentication authentication) {
        requireBuyerOwner(request == null ? null : request.buyer(), authentication);
        return manageCartUseCase.addProduct(request.buyer(), request.product());
    }

    @DeleteMapping("/items")
    public Cart removeProduct(
            @RequestBody CartItemRequest request,
            Authentication authentication) {
        requireBuyerOwner(request == null ? null : request.buyer(), authentication);
        return manageCartUseCase.removeProduct(request.buyer(), request.product());
    }

    @DeleteMapping
    public Cart clear(
            @RequestBody Buyer buyer,
            Authentication authentication) {
        requireBuyerOwner(buyer, authentication);
        return manageCartUseCase.clear(buyer);
    }

    private void requireBuyerOwner(Buyer buyer, Authentication authentication) {
        if (buyer == null || buyer.getId() == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        currentActorService.requireBuyerOwner(authentication, buyer.getId());
    }

    public record CartItemRequest(Buyer buyer, Product product) {}
}
