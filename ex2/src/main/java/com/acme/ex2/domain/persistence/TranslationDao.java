package com.acme.ex2.domain.persistence;

public interface TranslationDao 
{
	// a besoin d'une source de données à consulter
	public abstract String getTranslation(String in);
}