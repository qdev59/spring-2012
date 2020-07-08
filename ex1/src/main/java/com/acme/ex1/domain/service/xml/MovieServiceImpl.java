package com.acme.ex1.domain.service.xml;

import java.util.List;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.entity.Movie;
import com.acme.ex1.domain.service.MovieService;

class MovieServiceImpl implements MovieService {

	// j'ai besoin de WarnerMovieDaoImpl : FAUX
	// j'ai besoin de FoxMovieDaoImpl : FAUX
	// j'ai besoin d'une MovieDao : VRAI
	private final MovieDao dao;

	MovieServiceImpl(MovieDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Movie> findMovies(String name) {
		return this.dao.retrieve(name);
	}

}
