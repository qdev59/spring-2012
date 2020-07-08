package com.acme.common.business.exception;

public abstract class BusinessException extends Exception {

	private static final long serialVersionUID = 117400658952600303L;

	public BusinessException(String message) {
		super(message);
	}
}
