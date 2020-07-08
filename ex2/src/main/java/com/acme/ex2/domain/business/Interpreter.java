package com.acme.ex2.domain.business;

public interface Interpreter
{ 
	// a besoin d'un dictionnaire (une dao) pour travailler
	public abstract String translate(String wordValue);
}