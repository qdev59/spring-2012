package com.acme.ex3a;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CacheLoader {

	@Inject
	private EntityManagerFactory emf;

	@PostConstruct
	public void initCache() {
		EntityManager em = emf.createEntityManager();
		Map<String, Object> props = emf.getProperties();
		for(String s : props.keySet())
		{
			if(s.startsWith("hibernate.ejb.classcache."))
			{
				String className = s.replace("hibernate.ejb.classcache.", "");
				em.createQuery("from "+className).getResultList();
			}
		}
		em.close();
	}
}
