package com.acme.ex2.domain.business.impl;

import com.acme.ex2.domain.business.Interpreter;
import com.acme.ex2.domain.persistence.TranslationDao;

public class EnglishToSpanishInterpreterImpl implements Interpreter {

	private TranslationDao dao;
	
	public EnglishToSpanishInterpreterImpl(TranslationDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String translate(String wordValue) {
		// traitement sémantique, syntaxique (spécifique à une traduction en-sp), etc.. sur wordvalue
		// accès au référentiel des mots et récupération du résultat
		String result = this.dao.getTranslation(wordValue);
		// traitement sémantique, syntaxique (spécifique à une traduction en-sp), etc.. sur le résultat
		// // renvoie du résultat
		return result;
	}



}
