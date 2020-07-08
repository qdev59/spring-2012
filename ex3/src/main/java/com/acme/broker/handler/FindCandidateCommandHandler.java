package com.acme.broker.handler;

import com.acme.broker.command.FindCandidateCommand;
import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandHandler;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.CandidateManager;

public class FindCandidateCommandHandler implements CommandHandler {
	private final CandidateManager candidateManager;

	public FindCandidateCommandHandler(CandidateManager candidateManager) {
		super();
		this.candidateManager = candidateManager;
		System.out.println("I will be working with "+candidateManager.getClass().getName());
	}

	@Override
	public void handle(AbstractCommand cmd) throws BusinessException {
		if (cmd instanceof FindCandidateCommand) {
			FindCandidateCommand command = (FindCandidateCommand) cmd;
			if (command.getId() != null) {
				command.setSingleResult(this.candidateManager
						.getDetails(command.getId()));
			} else {
				command.setMultipleResults(this.candidateManager.find(command
						.getFilter()));
			}
		}
	}
}
