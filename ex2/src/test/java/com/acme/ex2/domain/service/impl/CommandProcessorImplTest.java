package com.acme.ex2.domain.service.impl;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.ex2.domain.command.TranslationCommand;
import com.acme.ex2.domain.entity.Word;
import com.acme.ex2.domain.service.CommandProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/acme/ex2/context/appCtx.xml")
public class CommandProcessorImplTest {

	@Inject
	private CommandProcessor processor;
	
	@Test
	public void testProcess() {
		System.out.println(processor.getClass().getName());
		
		Word w1 = new Word("hello", "en");
		Word w2 = new Word("fr");
		TranslationCommand cmd = new TranslationCommand(w1, w2);
		this.processor.process(cmd);
		Assert.assertEquals("bonjour", cmd.getOutput().getValue());
	}

}
