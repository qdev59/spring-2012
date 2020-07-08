package com.acme.ex5.messaging;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

@Named
public class Server implements MessageListener {

	@Resource
	private JmsTemplate template;
	
	@Override
	public void onMessage(Message arg0) {
		try {
			TextMessage txtMessage = (TextMessage)arg0;
			System.out.println("héhé [server] : "+txtMessage.getText());
			this.template.convertAndSend(txtMessage.getJMSReplyTo(), txtMessage.getText().toUpperCase());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
