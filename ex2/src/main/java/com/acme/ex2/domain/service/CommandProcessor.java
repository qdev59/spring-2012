package com.acme.ex2.domain.service;

public interface CommandProcessor
{
	public abstract void process(Object command);
}