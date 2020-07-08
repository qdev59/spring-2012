package com.acme.ex2.domain.business.impl;

import java.util.Map;

import com.acme.ex2.domain.business.Interpreter;
import com.acme.ex2.domain.business.InterpreterLocator;

public class InterpreterLocatorImpl implements InterpreterLocator {

	private Map<String, Interpreter> interpreters;
	
	public InterpreterLocatorImpl(Map<String, Interpreter> interpreters) {
		super();
		this.interpreters = interpreters;
	}

	@Override											//en-fr
	public Interpreter getAppropriateInterpreter(String langInOut) {
		Interpreter interpreter = this.interpreters.get(langInOut);
		if(interpreter==null)
		{
			String message = langInOut+" is not supported";
			throw new IllegalArgumentException(message);
		}
		return interpreter;
	}

}
