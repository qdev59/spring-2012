package com.acme.ex1.domain.service;

import java.util.List;

import com.acme.ex1.domain.entity.Movie;

public interface MovieService {
	List<Movie> findMovies(String name);
}
