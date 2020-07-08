package com.acme.common.broker;

public interface CommandPreProcessor {

	void preProcess(AbstractCommand command);
}
