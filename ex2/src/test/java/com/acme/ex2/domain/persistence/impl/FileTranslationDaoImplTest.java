package com.acme.ex2.domain.persistence.impl;

import javax.inject.Inject;
import javax.inject.Named;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/acme/ex2/context/appCtx.xml")
public class FileTranslationDaoImplTest {

	@Inject @Named("enSpDao")
	// ou @Resource(name="enSpDao")
	private FileTranslationDaoImpl dao;

	@Test
	public void testGetTranslation() {
		Assert.assertEquals("hola", dao.getTranslation("hello"));
	}

}
