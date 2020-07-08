package com.acme.ex4.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acme.broker.command.FindCandidateCommand;
import com.acme.broker.command.HireCandidateCommand;
import com.acme.common.broker.CommandProcessor;
import com.acme.common.business.exception.BusinessException;
import com.acme.ex3a.domain.business.filter.CandidateFilter;

@Controller @RequestMapping("candidates")
public class CandidateController {

	@Inject
	private CommandProcessor processor;
	
	// est appelé pour présenter le formulaire de recherche
	// http://localhost:8080/ex4/ui/candidates/index
	@RequestMapping(value="index", method=RequestMethod.GET)
	public ModelAndView index()
	{
		return new ModelAndView("candidate/index", "filter", new CandidateFilter());
	}
	
	// est appelé lorsque le formulaire de recherche est soumi
	// http://localhost:8080/ex4/ui/candidates/list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(@ModelAttribute("filter") @Valid CandidateFilter filter, BindingResult binding) throws BusinessException
	{
		ModelAndView mav = new ModelAndView("candidate/index", "filter", filter);
		if(binding.hasErrors())
		{
			return mav;
		}
		FindCandidateCommand cmd = new FindCandidateCommand();
		cmd.setFilter(filter);
		cmd = (FindCandidateCommand) this.processor.process(cmd);
		mav.addObject("results", cmd.getMultipleResults());
		return mav;
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	
	
	// est appelé lorsque l'on accède à la fiche d'un candidat
	// http://localhost:8080/ex4/ui/candidates/detail?id=1
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam("id") int id) throws BusinessException
	{
		FindCandidateCommand cmd = new FindCandidateCommand();
		cmd.setId(id);
		cmd = (FindCandidateCommand) this.processor.process(cmd);
		ModelAndView mav = new ModelAndView("candidate/detail", "candidate", cmd.getSingleResult());
		
		HireCandidateCommand command = new HireCandidateCommand();
		command.setCandidateId(id);
		mav.addObject("hireCandidateCommand", command);
		return mav;
	}
	
	@RequestMapping(value="hire", method=RequestMethod.POST)
	public ModelAndView hire(HireCandidateCommand cmd) throws BusinessException
	{
		System.out.println(cmd.getContract().getId());
		System.out.println(cmd.getCandidateId());
		System.out.println(cmd.getEndDate());
		System.out.println(cmd.getStartDate());
		cmd = (HireCandidateCommand) this.processor.process(cmd);
		return index();
	}
}
