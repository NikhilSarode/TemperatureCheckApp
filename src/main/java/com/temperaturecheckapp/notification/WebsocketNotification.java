package com.temperaturecheckapp.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.temperaturecheckapp.model.TempCriteria;

@Component("websocketnotification")
public class WebsocketNotification implements TempNotification{
	@Autowired
	private SimpMessagingTemplate template;

	@Override
	public void sendNotification(TempCriteria tempCriteria) {
		this.template.convertAndSend("/topic/messages", tempCriteria);
	}
}
