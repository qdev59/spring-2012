package com.acme.ex2.domain.entity;

public class Word
{
	private String lang;
	private String value;

	public Word(String value, String lang)
	{
		this.lang = lang;
		this.value = value;
	}
	
	public Word(String lang)
	{
		this.lang = lang;
	}
	
	public String getLang()
	{
		return lang;
	}

	public String getValue()
	{
		return value;
	}

	public void setLang(String lang)
	{
		this.lang = lang;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
