package com.acme.broker.handler;

import com.acme.broker.command.FindEmployeeCommand;
import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandHandler;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.EmployeeManager;

public class FindEmployeeCommandHandler implements CommandHandler {
	private final EmployeeManager employeeManager;

	public FindEmployeeCommandHandler(EmployeeManager employeeManager) {
		super();
		this.employeeManager = employeeManager;
	}

	@Override
	public void handle(AbstractCommand cmd) throws BusinessException {
		if (cmd instanceof FindEmployeeCommand) {
			FindEmployeeCommand command = (FindEmployeeCommand) cmd;
			if (command.getId() != null) {
				command.setSingleResult(this.employeeManager.getDetails(command
						.getId()));
			} else {
				command.setMultipleResults(this.employeeManager.find(command
						.getFilter()));
			}
		}
	}
}
