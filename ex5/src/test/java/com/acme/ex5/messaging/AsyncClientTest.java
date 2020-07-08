package com.acme.ex5.messaging;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/acme/ex5/context/appCtxJms.xml" })
public class AsyncClientTest {

	@Inject
	private AsyncClient client;

	@Test
	public void testSendRequest() throws Exception {
		client.sendRequest();
		client.sendRequest();
		client.sendRequest();
		client.sendRequest();
		client.sendRequest();
		client.sendRequest();
		client.sendRequest();
		
		Thread.sleep(5000);
	}

}
