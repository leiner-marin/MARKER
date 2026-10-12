package application.adapters.useCases;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import application.domain.enums.UserRole;
import application.domain.ports.in.ManageSellerUseCase;
import application.domain.ports.in.OnboardSellerUseCase;
import application.domain.ports.out.SellerRepositoryPort;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.ports.out.WarehouseRepositoryPort;
import application.domain.services.SellerOnboardingService;
import application.domain.services.SellerService;
import application.domain.services.WarehouseAssignmentService;

public class DefaultSellerUseCase implements OnboardSellerUseCase, ManageSellerUseCase {
    private final SellerRepositoryPort sellerRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final WarehouseRepositoryPort warehouseRepositoryPort;
    private final SellerOnboardingService sellerOnboardingService;
    private final WarehouseAssignmentService warehouseAssignmentService;
    private final SellerService sellerService;

    public DefaultSellerUseCase(
            SellerRepositoryPort sellerRepositoryPort,
            UserRepositoryPort userRepositoryPort,
            WarehouseRepositoryPort warehouseRepositoryPort,
            SellerOnboardingService sellerOnboardingService,
            WarehouseAssignmentService warehouseAssignmentService,
            SellerService sellerService) {
        this.sellerRepositoryPort = sellerRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.warehouseRepositoryPort = warehouseRepositoryPort;
        this.sellerOnboardingService = sellerOnboardingService;
        this.warehouseAssignmentService = warehouseAssignmentService;
        this.sellerService = sellerService;
    }

    @Override
    public Seller update(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller is required.");
        }
        seller.setRole(UserRole.SELLER);
        sellerService.validate(seller);
        Seller current = findById(seller.getId());
        if (!current.getEmail().equalsIgnoreCase(seller.getEmail())
                && userRepositoryPort.existsByEmail(seller.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        userRepositoryPort.update(seller);
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
        if (seller == null) {
            throw new IllegalArgumentException("Seller is required.");
        }
        seller.setRole(UserRole.SELLER);
        sellerService.validate(seller);
        if (userRepositoryPort.existsByEmail(seller.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        Seller onboarded = sellerOnboardingService.onboard(seller);
        userRepositoryPort.save(onboarded);
        return sellerRepositoryPort.save(onboarded);
    }

    @Override
    public Seller assignWarehouse(Seller seller, Warehouse warehouse) {
        Seller current = findById(seller == null ? null : seller.getId());
        Warehouse assigned = warehouseAssignmentService.assign(current, warehouse);
        if (assigned.getId() == null) {
            warehouseRepositoryPort.save(assigned);
        } else {
            warehouseRepositoryPort.update(assigned);
        }
        return sellerRepositoryPort.update(current);
    }
}
