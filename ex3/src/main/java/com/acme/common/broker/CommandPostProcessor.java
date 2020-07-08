package com.acme.common.broker;

public interface CommandPostProcessor {

	void postProcess(AbstractCommand command);
}
