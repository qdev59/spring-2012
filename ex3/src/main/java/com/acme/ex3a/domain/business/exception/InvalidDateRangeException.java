package com.acme.ex3a.domain.business.exception;

import com.acme.common.business.exception.BusinessException;

public class InvalidDateRangeException extends BusinessException {

	private static final long serialVersionUID = 2185948901845788283L;

	public InvalidDateRangeException() {
		super("invalid.daterange");
	}
}
