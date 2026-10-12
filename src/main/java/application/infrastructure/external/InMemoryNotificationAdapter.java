package application.infrastructure.external;

import application.domain.ports.out.NotificationPort;
import org.springframework.stereotype.Component;

@Component
public class InMemoryNotificationAdapter implements NotificationPort {
    @Override
    public void send(String recipient, String subject, String message) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Notification recipient is required.");
        }
    }
}
