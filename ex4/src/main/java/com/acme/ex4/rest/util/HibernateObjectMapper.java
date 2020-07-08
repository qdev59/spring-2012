package com.acme.ex4.rest.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

import com.fasterxml.jackson.module.hibernate.HibernateModule;

public class HibernateObjectMapper extends ObjectMapper {
	public HibernateObjectMapper() {
		
		super.registerModule(new HibernateModule());
		configure(Feature.FAIL_ON_EMPTY_BEANS, true);
	}
}
