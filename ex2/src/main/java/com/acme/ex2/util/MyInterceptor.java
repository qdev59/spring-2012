package com.acme.ex2.util;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class MyInterceptor {

	private boolean enabled = true;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// @Around("execution(* com.acme.ex2.domain.service.*.*(..)")
	public void intercept(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("entering advice");
		pjp.proceed();
		System.out.println("exiting advice");
	}
}
