package com.acme._demoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyContainer {

	private static Map<String, Object> beans = new HashMap<>();
	
	static
	{
		try {
			String id = "helloService";
			String className = "com.acme._demoProxy.impl.HelloServiceImpl";
			Class<?> clazz = Class.forName(className);
			Object instance = clazz.newInstance();
			beans.put(id, requiresInterception(clazz) ? createProxy(instance) : instance);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean requiresInterception(Class<?> clazz)
	{
		return false;
	}
	
	private static Object createProxy(final Object target)
	{
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("entering proxy");
				Object out = method.invoke(target, args);
				System.out.println("exiting proxy");
				return out;
			}
		});
	}
	
	
	
	public static Object getBean(String id)
	{
		return beans.get(id);
	}
	
	
	
	public static void main(String[] args) {
		HelloService service = (HelloService) MyContainer.getBean("helloService");
		System.out.println(service.getClass().getName());
		System.out.println(service.sayHello("John Doe"));
	}
	
}
