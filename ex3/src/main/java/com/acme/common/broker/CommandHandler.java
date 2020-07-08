package com.acme.common.broker;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.common.business.exception.BusinessException;

@Transactional(propagation=Propagation.MANDATORY)
public interface CommandHandler {

	void handle(AbstractCommand cmd) throws BusinessException;
}
