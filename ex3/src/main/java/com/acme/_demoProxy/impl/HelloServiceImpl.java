package com.acme._demoProxy.impl;

import com.acme._demoProxy.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("entering sayHello");
		String output ="hello "+name;
		System.out.println("exiting sayHello");
		return output;
	}

}
