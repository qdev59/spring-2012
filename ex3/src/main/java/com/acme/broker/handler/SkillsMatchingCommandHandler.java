package com.acme.broker.handler;

import com.acme.broker.command.SkillsMatchingCommand;
import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandHandler;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.CandidateManager;
import com.acme.ex3a.domain.business.EmployeeManager;

public class SkillsMatchingCommandHandler implements CommandHandler {
	private final CandidateManager candidateManager;
	private final EmployeeManager employeeManager;

	public SkillsMatchingCommandHandler(CandidateManager candidateManager,
			EmployeeManager employeeManager) {
		super();
		this.candidateManager = candidateManager;
		this.employeeManager = employeeManager;
	}

	@Override
	public void handle(AbstractCommand cmd) throws BusinessException {
		if ((cmd instanceof SkillsMatchingCommand)) {
			SkillsMatchingCommand command = (SkillsMatchingCommand) cmd;
			command.setCandidates(this.candidateManager.match(
					command.getTechnicalSkills(), command.getBusinessSkills()));
			command.setEmployees(this.employeeManager.match(
					command.getTechnicalSkills(), command.getBusinessSkills()));
		}

	}

}
