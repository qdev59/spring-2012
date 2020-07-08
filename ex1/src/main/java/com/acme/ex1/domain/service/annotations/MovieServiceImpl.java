package com.acme.ex1.domain.service.annotations;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.dao.MovieDao.Kid;
import com.acme.ex1.domain.entity.Movie;
import com.acme.ex1.domain.service.MovieService;

@Named
class MovieServiceImpl implements MovieService {

	private final MovieDao dao;

	@Inject
	MovieServiceImpl(@Kid MovieDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Movie> findMovies(String name) {
		return this.dao.retrieve(name);
	}

}
