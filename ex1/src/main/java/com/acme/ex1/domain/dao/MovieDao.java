package com.acme.ex1.domain.dao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import javax.inject.Qualifier;

import com.acme.ex1.domain.entity.Movie;

public interface MovieDao {

	List<Movie> retrieve(String name);
	
	@javax.inject.Qualifier
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Kid{
		
		
	}
	
	public enum MovieType {BOY, GIRL}
	
}
