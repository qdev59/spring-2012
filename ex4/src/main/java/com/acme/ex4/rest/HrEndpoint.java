package com.acme.ex4.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.broker.command.FindCandidateCommand;
import com.acme.broker.command.FindEmployeeCommand;
import com.acme.broker.command.HireCandidateCommand;
import com.acme.common.broker.CommandProcessor;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.filter.CandidateFilter;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;
import com.acme.ex3a.domain.entity.Candidate;
import com.acme.ex3a.domain.entity.Employee;

@Controller
public class HrEndpoint {

	@Inject
	private CommandProcessor processor;

	@RequestMapping(value="candidates/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Candidate candidate(@PathVariable("id") int id) throws BusinessException {
		FindCandidateCommand cmd = new FindCandidateCommand();
		cmd.setId(id);
		cmd = (FindCandidateCommand) this.processor.process(cmd);
		return cmd.getSingleResult();
	}
	
	@RequestMapping(value="candidates", method=RequestMethod.GET)
	@ResponseBody
	public List<Candidate> candidates(@RequestParam String name, @RequestParam Integer managerId) throws BusinessException {
		FindCandidateCommand cmd = new FindCandidateCommand();
		CandidateFilter filter = new CandidateFilter();
		filter.setName(name);
		filter.setManagerId(managerId);
		cmd.setFilter(filter);
		cmd = (FindCandidateCommand) this.processor.process(cmd);
		return cmd.getMultipleResults();
	}
	
	@RequestMapping(value="employees/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Employee employee(@PathVariable("id") int id) throws BusinessException {
		FindEmployeeCommand cmd = new FindEmployeeCommand();
		cmd.setId(id);
		cmd = (FindEmployeeCommand) this.processor.process(cmd);
		return cmd.getSingleResult();
	}
	
	@RequestMapping(value="employees", method=RequestMethod.GET)
	@ResponseBody
	public List<Employee> employees(@RequestBody EmployeeFilter filter) throws BusinessException {
		FindEmployeeCommand cmd = new FindEmployeeCommand();
		cmd.setFilter(filter);
		cmd = (FindEmployeeCommand) this.processor.process(cmd);
		return cmd.getMultipleResults();
	}	
	
	@RequestMapping(value="hire", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Employee> hire(@RequestBody HireCandidateCommand cmd) throws BusinessException
	{
		cmd = (HireCandidateCommand) this.processor.process(cmd);
		return new ResponseEntity<Employee>(cmd.getEmployee(), HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
