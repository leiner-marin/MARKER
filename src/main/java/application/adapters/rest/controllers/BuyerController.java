package application.adapters.rest.controllers;

import application.adapters.rest.dtos.buyer.BuyerRequest;
import application.adapters.rest.dtos.buyer.BuyerResponse;
import application.adapters.rest.mappers.BuyerRestMapper;
import application.domain.entities.Buyer;
import application.domain.ports.in.ManageBuyerUseCase;
import application.domain.ports.in.RegisterBuyerUseCase;
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
@RequestMapping("/api/buyers")
public class BuyerController {
    private final RegisterBuyerUseCase registerBuyerUseCase;
    private final ManageBuyerUseCase manageBuyerUseCase;
    private final CurrentActorService currentActorService;

    public BuyerController(
            RegisterBuyerUseCase registerBuyerUseCase,
            ManageBuyerUseCase manageBuyerUseCase,
            CurrentActorService currentActorService) {
        this.registerBuyerUseCase = registerBuyerUseCase;
        this.manageBuyerUseCase = manageBuyerUseCase;
        this.currentActorService = currentActorService;
    }

    @PostMapping
    public BuyerResponse register(@RequestBody BuyerRequest request) {
        return BuyerRestMapper.toResponse(
                registerBuyerUseCase.register(BuyerRestMapper.toDomain(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyerResponse> findById(
            @PathVariable Long id,
            Authentication authentication) {
        if (currentActorService.isBuyer(authentication)) {
            currentActorService.requireBuyerOwner(authentication, id);
        }
        return ResponseEntity.ok(
                BuyerRestMapper.toResponse(manageBuyerUseCase.findById(id)));
    }

    @PutMapping("/{id}")
    public BuyerResponse update(
            @PathVariable Long id,
            @RequestBody BuyerRequest request,
            Authentication authentication) {
        if (currentActorService.isBuyer(authentication)) {
            currentActorService.requireBuyerOwner(authentication, id);
        }
        Buyer buyer = BuyerRestMapper.toDomain(request);
        buyer.setId(id);
        return BuyerRestMapper.toResponse(manageBuyerUseCase.update(buyer));
    }

    @PostMapping("/{id}/addresses")
    public BuyerResponse addAddress(
            @PathVariable Long id,
            @RequestBody AddressRequest request,
            Authentication authentication) {
        if (currentActorService.isBuyer(authentication)) {
            currentActorService.requireBuyerOwner(authentication, id);
        }
        return BuyerRestMapper.toResponse(manageBuyerUseCase.addAddress(id, request.address()));
    }

    public record AddressRequest(String address) {}
}
