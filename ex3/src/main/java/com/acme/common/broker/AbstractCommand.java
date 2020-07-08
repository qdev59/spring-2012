package com.acme.common.broker;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class AbstractCommand implements Serializable{

	private static final long serialVersionUID = 2496698567175987877L;

	public boolean readOnly;

	private boolean forwarded = false;

	public boolean isForwarded() {
		return forwarded;
	}

	public void setForwarded(boolean forwarded) {
		this.forwarded = forwarded;
	}

	public AbstractCommand(boolean readOnly) {
		super();
		this.readOnly = readOnly;
	}
	
	public void validateStateBeforeProcess(){}
	
	public void validateStateAfterProcess(){}
	
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Usecase{
		String name() default "";
		String developer() default "";
		//Class<? extends CommandHandler>[] handlers() default;
	}
}
