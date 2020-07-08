package com.acme.ex2.domain.service.impl;

import com.acme.ex2.domain.business.Interpreter;
import com.acme.ex2.domain.business.InterpreterLocator;
import com.acme.ex2.domain.command.TranslationCommand;
import com.acme.ex2.domain.service.CommandProcessor;

public class CommandProcessorImpl implements CommandProcessor {

	// a besoin d'un InterpreterLocator
	private InterpreterLocator locator;
	
	public CommandProcessorImpl(InterpreterLocator locator) {
		super();
		this.locator = locator;
	}

	@Override
	public void process(Object command) {
		System.out.println("entering process");
		if (command instanceof TranslationCommand) {
			TranslationCommand cmd = (TranslationCommand) command;
			// extraction de la langue d'entrée et de la langue de sortie
			String langIn = cmd.getInput().getLang();
			String langOut = cmd.getOutput().getLang();
			String langInOut = langIn+"-"+langOut;
			
			// récupération du bon interpreter
			Interpreter interpreter = this.locator.getAppropriateInterpreter(langInOut);
			// récupération de la traduction (en sollicitant l'interpreter récupéré précédemment)
			String valueIn = cmd.getInput().getValue();
			String result = interpreter.translate(valueIn); 
			// inscription du résultat dans la commande
			cmd.getOutput().setValue(result);
		}
		System.out.println("exiting process");
	}

}
