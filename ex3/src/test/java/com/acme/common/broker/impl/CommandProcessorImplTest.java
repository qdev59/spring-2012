package com.acme.common.broker.impl;

import java.util.Calendar;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.broker.command.FindCandidateCommand;
import com.acme.broker.command.HireCandidateCommand;
import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandProcessor;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.filter.CandidateFilter;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.Contract;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/acme/appCtxBroker.xml")
public class CommandProcessorImplTest {

	@Inject
	private CommandProcessor processor;

	@SuppressWarnings("unchecked")
	private <T extends AbstractCommand> T process(T command) throws BusinessException {
		return (T) processor.process(command);
	}

	@Test
	public void testFindCandidateCommand() throws BusinessException
	{
		FindCandidateCommand cmd = new FindCandidateCommand();
		cmd.setFilter(new CandidateFilter());
		cmd = (FindCandidateCommand) this.processor.process(cmd);
		for(Candidate candidate : cmd.getMultipleResults())
		{
			System.out.println(candidate.getIdentity().getLastname()+" "+candidate.getIdentity().getFirstname());
		}
	}
	
	
	
	@Test(expected = BusinessException.class)
	public void testHireCandidateCommandOnError() throws BusinessException {
		Contract contract = new Contract();
		contract.setId(1);

		HireCandidateCommand cmd = new HireCandidateCommand();
		cmd.setCandidateId(1);
		cmd.setStartDate(Calendar.getInstance().getTime());
		cmd.setContract(contract);

		cmd = (HireCandidateCommand) this.processor.process(cmd);
	}

	@Test(expected = BusinessException.class)
	public void testHireCandidateCommandWithDuplicateLogin() throws BusinessException {
		Contract contract = new Contract();
		contract.setId(1);

		HireCandidateCommand cmd = new HireCandidateCommand();
		cmd.setCandidateId(2);
		cmd.setStartDate(Calendar.getInstance().getTime());
		cmd.setContract(contract);

		cmd = process(cmd);
		System.out.println(cmd.getEmployee().getId());
	}

}
