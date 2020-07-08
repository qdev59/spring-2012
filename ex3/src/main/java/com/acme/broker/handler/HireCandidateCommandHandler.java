package com.acme.broker.handler;

import java.util.HashMap;

import javax.annotation.security.RolesAllowed;

import com.acme.broker.command.HireCandidateCommand;
import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandHandler;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.CandidateManager;
import com.acme.ex3a.domain.business.EmployeeManager;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.Employee;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

@RolesAllowed("ROLE_ADMIN")
public class HireCandidateCommandHandler implements CommandHandler {

	private final CandidateManager candidateManager;
	private final EmployeeManager employeeManager;
	
	public HireCandidateCommandHandler(CandidateManager candidateManager,
			EmployeeManager employeeManager) {
		super();
		this.candidateManager = candidateManager;
		this.employeeManager = employeeManager;
	}

	@Override
	public void handle(AbstractCommand cmd) throws BusinessException {
		
		if((cmd instanceof HireCandidateCommand))
		{
			HireCandidateCommand command = (HireCandidateCommand)cmd;
			Candidate candidate = this.candidateManager.getDetails(command.getCandidateId());
			
			Employee employee = new Employee();
			employee.setIdentity(candidate.getIdentity());
			employee.setBusinessSkills(new HashMap<BusinessDomain, SkillLevel>(candidate.getBusinessSkills()));
			employee.setTechnicalSkills(new HashMap<TechnicalDomain, SkillLevel>(candidate.getTechnicalSkills()));
			
			employee.setStartDate(command.getStartDate());
			employee.setEndDate(command.getEndDate());
			employee.setContract(command.getContract());
			
			this.candidateManager.delete(candidate);
			command.setEmployee(this.employeeManager.save(employee));
		}
	}
}
