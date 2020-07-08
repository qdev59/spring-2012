package com.acme.ex1.domain.service.xml;

import java.util.ArrayList;
import java.util.List;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.entity.Movie;
import com.acme.ex1.domain.service.MovieService;

class SuperMovieServiceImpl implements MovieService {

	// j'ai besoin de WarnerMovieDaoImpl et de FoxMovieDaoImpl : FAUX
	// j'ai besoin de MovieDao(s) : VRAI
	private final Iterable<MovieDao> daos;
	
	SuperMovieServiceImpl(List<MovieDao> daos) {
		super();
		this.daos = daos;
	}

	
	@Override
	public List<Movie> findMovies(String name) {
		ArrayList<Movie> movies = new ArrayList<>();

		for(MovieDao dao : this.daos)
		{
			List<Movie> results = dao.retrieve(name);
			movies.addAll(results);
		}
		return movies;
	}

}
