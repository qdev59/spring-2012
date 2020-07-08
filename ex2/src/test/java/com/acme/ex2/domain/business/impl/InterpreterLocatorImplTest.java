package com.acme.ex2.domain.business.impl;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.ex2.domain.business.Interpreter;
import com.acme.ex2.domain.business.InterpreterLocator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/acme/ex2/context/appCtx.xml")
public class InterpreterLocatorImplTest {

	@Inject
	private InterpreterLocator locator;
	
	@Test
	public void testGetAppropriateInterpreter() {
		Interpreter interpreter = this.locator.getAppropriateInterpreter("en-fr");
		Assert.assertNotNull(interpreter);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAppropriateInterpreterWithInvalidLangInOut() {
		this.locator.getAppropriateInterpreter("en-ru");
	}

}
