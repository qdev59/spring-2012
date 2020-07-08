package com.acme.common.broker;

import com.acme.common.business.exception.BusinessException;

public interface CommandProcessor {

	public AbstractCommand process(AbstractCommand command) throws BusinessException;
}
