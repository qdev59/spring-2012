package com.acme.ex4.ui;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acme.broker.command.FindEmployeeCommand;
import com.acme.common.broker.CommandProcessor;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	@Inject
	private CommandProcessor processor;

	@RequestMapping(value="index", method=RequestMethod.GET)
	public ModelAndView index()
	{
		return new ModelAndView("employee/index", "filter", new EmployeeFilter());	
	}
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(EmployeeFilter filter) throws BusinessException
	{
		FindEmployeeCommand cmd = new FindEmployeeCommand();
		cmd.setFilter(filter);
		cmd = (FindEmployeeCommand) this.processor.process(cmd);
		ModelAndView mav = new ModelAndView("employee/index", "results", cmd.getMultipleResults());
		mav.addObject("filter", filter);
		return mav;		
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam("id") int id) throws BusinessException
	{
		FindEmployeeCommand cmd = new FindEmployeeCommand();
		cmd.setId(id);
		cmd = (FindEmployeeCommand) this.processor.process(cmd);
		return new ModelAndView("employee/detail", "employee", cmd.getSingleResult());
	}
}
