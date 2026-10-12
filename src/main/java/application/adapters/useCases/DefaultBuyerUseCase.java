package application.adapters.useCases;

import application.domain.entities.Buyer;
import application.domain.enums.UserRole;
import application.domain.ports.in.ManageBuyerUseCase;
import application.domain.ports.in.RegisterBuyerUseCase;
import application.domain.ports.out.BuyerRepositoryPort;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.services.BuyerAddressService;
import application.domain.services.BuyerService;

public class DefaultBuyerUseCase implements RegisterBuyerUseCase, ManageBuyerUseCase {
    private final BuyerRepositoryPort buyerRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final BuyerService buyerService;
    private final BuyerAddressService buyerAddressService;

    public DefaultBuyerUseCase(
            BuyerRepositoryPort buyerRepositoryPort,
            UserRepositoryPort userRepositoryPort,
            BuyerService buyerService,
            BuyerAddressService buyerAddressService) {
        this.buyerRepositoryPort = buyerRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.buyerService = buyerService;
        this.buyerAddressService = buyerAddressService;
    }

    @Override
    public Buyer register(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        buyer.setRole(UserRole.BUYER);
        buyerService.register(buyer);
        if (userRepositoryPort.existsByEmail(buyer.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (userRepositoryPort.existsByIdentityDocument(buyer.getIdentityDocument())) {
            throw new IllegalArgumentException("Identity document is already registered.");
        }
        userRepositoryPort.save(buyer);
        return buyerRepositoryPort.save(buyer);
    }

    @Override
    public Buyer update(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        buyer.setRole(UserRole.BUYER);
        buyerService.validate(buyer);
        Buyer current = findById(buyer.getId());
        if (!current.getEmail().equalsIgnoreCase(buyer.getEmail())
                && userRepositoryPort.existsByEmail(buyer.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (!current.getIdentityDocument().equalsIgnoreCase(buyer.getIdentityDocument())
                && userRepositoryPort.existsByIdentityDocument(buyer.getIdentityDocument())) {
            throw new IllegalArgumentException("Identity document is already registered.");
        }
        userRepositoryPort.update(buyer);
        return buyerRepositoryPort.update(buyer);
    }

    @Override
    public Buyer findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Buyer id is required.");
        }
        return buyerRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Buyer not found."));
    }

    @Override
    public Buyer addAddress(Long buyerId, String address) {
        Buyer buyer = findById(buyerId);
        buyerAddressService.addAddress(buyer, address);
        return buyerRepositoryPort.update(buyer);
    }
}
