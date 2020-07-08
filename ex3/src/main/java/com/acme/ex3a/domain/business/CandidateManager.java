package com.acme.ex3a.domain.business;

import java.util.List;
import java.util.Map;

import com.acme.ex3a.domain.business.filter.CandidateFilter;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

public interface CandidateManager {

	Candidate getDetails(int id);
	
	Candidate save(Candidate candidate);
	
	List<Candidate> find(CandidateFilter filter);
	
	void delete(int id);
	
	void delete(Candidate candidate);
	
	List<Candidate> match(Map<TechnicalDomain, SkillLevel> technicalDomains, Map<BusinessDomain, SkillLevel> businessDomains);
}
