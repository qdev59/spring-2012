package com.acme.ex3a.domain.business.exception;

import com.acme.common.business.exception.BusinessException;

public class DuplicateLoginException extends BusinessException {


	private static final long serialVersionUID = 5488323077370340425L;

	public DuplicateLoginException() {
		super("duplicate.login");
	}
}
