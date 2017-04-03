package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@RequestMapping(
			value = "/api/notifications", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getHola() {
		// se envian las notificaciones a los topicos del web socket
		this.getTemplate().convertAndSend("/topic/notifications.55", new Notification("notification 55"));
		this.getTemplate().convertAndSend("/topic/notifications.11", new Notification("notification 11"));
		this.getTemplate().convertAndSend("/topic/notifications.22", new Notification("notification 22"));
		this.getTemplate().convertAndSend("/topic/notifications", new Notification("broadcast"));
		return "notifications";
	}

	public SimpMessagingTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpMessagingTemplate template) {
		this.template = template;
	}

}
