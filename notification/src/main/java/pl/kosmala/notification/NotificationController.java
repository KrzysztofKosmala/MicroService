package pl.kosmala.notification;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kosmala.clients.notification.NotificationRequest;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController
{

    private final NotificationService notificationService;

    @PostMapping(path = "send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest)
    {

        //send
        notificationService.sendNotification(notificationRequest);
        //save
        //handle exceptions
        return  new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
