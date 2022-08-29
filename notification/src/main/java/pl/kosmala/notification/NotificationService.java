package pl.kosmala.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kosmala.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService
{

    private NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest)
    {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .sender("admin")
                .build();
        notificationRepository.save(notification);
    }
}
