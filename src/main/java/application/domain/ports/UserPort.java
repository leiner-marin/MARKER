package application.domain.ports;

import application.domain.models.Buyer;
import application.domain.models.User;

public interface UserPort {
    Buyer registerUser(Buyer user);
    boolean authenticateUser(String email, String password);
    String getUserStatus(User user);
    User updateUserStatus(User user, String newStatus);
}
