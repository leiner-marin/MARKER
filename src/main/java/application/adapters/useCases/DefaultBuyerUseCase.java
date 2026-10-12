package application.adapters.useCases;

import application.domain.entities.Buyer;
import application.domain.ports.in.ManageBuyerUseCase;
import application.domain.ports.in.RegisterBuyerUseCase;
import application.domain.ports.out.BuyerRepositoryPort;
import application.domain.services.BuyerService;

public class DefaultBuyerUseCase implements RegisterBuyerUseCase, ManageBuyerUseCase {
    private final BuyerRepositoryPort buyerRepositoryPort;
    private final BuyerService buyerService;

    public DefaultBuyerUseCase(BuyerRepositoryPort buyerRepositoryPort, BuyerService buyerService) {
        this.buyerRepositoryPort = buyerRepositoryPort;
        this.buyerService = buyerService;
    }

    @Override
    public Buyer register(Buyer buyer) {
        return buyerRepositoryPort.save(buyerService.registerBuyer(buyer));
    }

    @Override
    public Buyer update(Buyer buyer) {
        buyerService.registerBuyer(buyer);
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
}
