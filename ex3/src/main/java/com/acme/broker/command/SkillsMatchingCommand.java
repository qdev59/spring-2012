package com.acme.broker.command;

import java.util.List;
import java.util.Map;

import com.acme.common.broker.AbstractCommand;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.Employee;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

public class SkillsMatchingCommand extends AbstractCommand {

	private static final long serialVersionUID = -1843701796913349797L;

	public SkillsMatchingCommand() {
		super(true);
	}

	private Map<BusinessDomain, SkillLevel> businessSkills;
	private Map<TechnicalDomain, SkillLevel> technicalSkills;

	private List<Candidate> candidates;
	private List<Employee> employees;

	public Map<BusinessDomain, SkillLevel> getBusinessSkills() {
		return businessSkills;
	}

	public void setBusinessSkills(Map<BusinessDomain, SkillLevel> businessSkills) {
		this.businessSkills = businessSkills;
	}

	public Map<TechnicalDomain, SkillLevel> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(
			Map<TechnicalDomain, SkillLevel> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
