package application.infrastructure.security;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CurrentActorService {
    private static final String ADMIN_ROLE = "ROLE_ADMINISTRATOR";
    private static final String BUYER_ROLE = "ROLE_BUYER";
    private static final String SELLER_ROLE = "ROLE_SELLER";

    @Value("${APP_SECURITY_BUYER_ID:1}")
    private Long configuredBuyerId;

    @Value("${APP_SECURITY_SELLER_ID:1}")
    private Long configuredSellerId;

    public void requireBuyerOwner(Authentication authentication, Long buyerId) {
        requireAuthenticated(authentication);
        if (hasRole(authentication, ADMIN_ROLE)) {
            return;
        }
        if (!hasRole(authentication, BUYER_ROLE) || !Objects.equals(configuredBuyerId, buyerId)) {
            throw new AccessDeniedException("The authenticated buyer can only manage its own information.");
        }
    }

    public void requireSellerOwner(Authentication authentication, Long sellerId) {
        requireAuthenticated(authentication);
        if (hasRole(authentication, ADMIN_ROLE)) {
            return;
        }
        if (!hasRole(authentication, SELLER_ROLE) || !Objects.equals(configuredSellerId, sellerId)) {
            throw new AccessDeniedException("The authenticated seller can only manage its own information.");
        }
    }

    public boolean isBuyer(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated() && hasRole(authentication, BUYER_ROLE);
    }

    public boolean isSeller(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated() && hasRole(authentication, SELLER_ROLE);
    }

    private void requireAuthenticated(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AuthenticationCredentialsNotFoundException("Authentication is required.");
        }
    }

    private boolean hasRole(Authentication authentication, String role) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (role.equals(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}
