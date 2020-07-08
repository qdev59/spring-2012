package com.acme.ex5.messaging;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

@Named
public class AsyncClient implements MessageListener {

	// recevoir le jmsTemplate par injection
	@Resource
	private JmsTemplate jmsTemplate;
	
	// recevoir une destination (une Queue par exemple) par injection
	@Resource(name="myReqDest")
	private Destination myDest;
	
	// recevoir une destination (une Queue par exemple) par injection
	@Resource(name="myRespDest")
	private Destination myDest2;	
	
	public void sendRequest() {
		// utiliser le jmsTemplate pour envoyer un message sur la destination
		this.jmsTemplate.convertAndSend(myDest, "hello world "+System.currentTimeMillis(), new MessagePostProcessor() {
			
			@Override
			public Message postProcessMessage(Message arg0) throws JMSException {
				arg0.setJMSReplyTo(myDest2);
				return arg0;
			}
		});
	}

	@Override
	public void onMessage(Message arg0) {
		try {
			TextMessage txtMessage = (TextMessage)arg0;
			String txt = txtMessage.getText();
			System.out.println("I (asyncClient) received a message : "+txt);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}