package com.acme.common.broker.impl;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandPostProcessor;
import com.acme.common.broker.CommandPreProcessor;

@ManagedResource
public class LoggerPrePostProcessor implements CommandPostProcessor,
		CommandPreProcessor {

	private boolean enabled;
	
	
	@ManagedOperation
	public boolean isEnabled() {
		return enabled;
	}

	@ManagedOperation
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public void preProcess(AbstractCommand command) {
		String filename = command.toString() + ".in.xml";
		log(command, filename);
	}

	@Override
	public void postProcess(AbstractCommand command) {
		String filename = command.toString() + ".out.xml";
		log(command, filename);
	}

	private void log(AbstractCommand command, String filename) {
		if(!enabled) return;
		System.out.println("serialize " + command.toString()+" under "+filename);
	}
}
