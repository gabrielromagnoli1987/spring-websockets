package hello;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationsWebSocketController {
	
	@MessageMapping("/notifications.{notificationId}")
    @SendTo("/topic/notifications.{notificationId}")
    public Notification getNotification(Notification notification, @DestinationVariable String notificationId) {
        return new Notification(notification.getName());
    }
	
}
