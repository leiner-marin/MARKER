package application.adapters.useCases;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.ports.in.OnboardSellerUseCase;
import application.domain.ports.out.SellerRepositoryPort;
import application.domain.services.SellerOnboardingService;
import application.domain.services.SellerService;
import application.domain.ports.in.ManageSellerUseCase;
import application.domain.services.WarehouseAssignmentService;

public class DefaultSellerUseCase implements OnboardSellerUseCase, ManageSellerUseCase {
    private final SellerRepositoryPort sellerRepositoryPort;
    private final SellerOnboardingService sellerOnboardingService;
    private final WarehouseAssignmentService warehouseAssignmentService;
    private final SellerService sellerService;

    public DefaultSellerUseCase(
            SellerRepositoryPort sellerRepositoryPort,
            SellerOnboardingService sellerOnboardingService,
            WarehouseAssignmentService warehouseAssignmentService,
            SellerService sellerService) {
        this.sellerRepositoryPort = sellerRepositoryPort;
        this.sellerOnboardingService = sellerOnboardingService;
        this.warehouseAssignmentService = warehouseAssignmentService;
        this.sellerService = sellerService;
    }

    @Override
    public Seller update(Seller seller) {
        sellerService.validate(seller);
        return sellerRepositoryPort.update(seller);
    }

    @Override
    public Seller findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Seller id is required.");
        }
        return sellerRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seller not found."));
    }

    @Override
    public Seller onboard(Seller seller) {
        return sellerRepositoryPort.save(sellerOnboardingService.onboard(seller));
    }

    @Override
    public Seller assignWarehouse(Seller seller, Warehouse warehouse) {
        Seller updated = sellerRepositoryPort.findById(seller == null ? null : seller.getId())
                .orElse(seller);
        if (updated == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        warehouseAssignmentService.assign(updated, warehouse);
        return sellerRepositoryPort.update(updated);
    }
}
