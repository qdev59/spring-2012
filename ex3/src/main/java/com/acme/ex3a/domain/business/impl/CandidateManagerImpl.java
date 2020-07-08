package com.acme.ex3a.domain.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.acme.ex3a.domain.business.CandidateManager;
import com.acme.ex3a.domain.business.filter.CandidateFilter;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

public class CandidateManagerImpl implements CandidateManager {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Candidate getDetails(int id) {
		String s = "select c from Candidate c join fetch c.manager where c.id=:id";
		TypedQuery<Candidate> c = this.em.createQuery(s, Candidate.class).setParameter("id", id);
		return c.getSingleResult();
	}

	@Override
	public Candidate save(Candidate candidate) {
		this.em.persist(candidate);
		return candidate;
	}

	@Override
	public List<Candidate> find(CandidateFilter filter) {
		String sQuery = "select c from Candidate c join fetch c.manager ";
		sQuery += "where (:name is null or c.identity.lastname like :name) ";
		sQuery += "and (:managerId is null or c.manager.id=:managerId)";
		TypedQuery<Candidate> query = this.em.createQuery(sQuery, Candidate.class);
		query.setParameter("name", filter.getName());
		query.setParameter("managerId",filter.getManagerId());
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		Candidate candidate = this.em.find(Candidate.class, id);
		delete(candidate);
	}

	@Override
	public void delete(Candidate candidate) {
		this.em.remove(candidate);
	}

	@Override
	public List<Candidate> match(
			Map<TechnicalDomain, SkillLevel> technicalDomains,
			Map<BusinessDomain, SkillLevel> businessDomains) {
		
		boolean matchTechnicakSkills = (technicalDomains!=null && !technicalDomains.isEmpty());
		boolean matchBusinessSkills = (businessDomains!=null && !businessDomains.isEmpty());
		
		List<Candidate> allCandidates = this.em.createQuery("from Candidate", Candidate.class).getResultList();
		
		ArrayList<Candidate> results = new ArrayList<Candidate>();
		for (Candidate candidate : allCandidates) {
			boolean a = false;
			boolean b = false;
			
			if(!matchBusinessSkills || candidate.getBusinessSkills().keySet().containsAll(businessDomains.keySet()))
			{
				a = true;
			}
			if(!matchTechnicakSkills || candidate.getTechnicalSkills().keySet().containsAll(technicalDomains.keySet()))
			{
				b = true;
			}
			if(a && b)
			{
				results.add(candidate);
			}
		}
		
		return results;
	}

}
