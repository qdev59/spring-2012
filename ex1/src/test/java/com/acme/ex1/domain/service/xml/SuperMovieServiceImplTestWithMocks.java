package com.acme.ex1.domain.service.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.entity.Movie;

public class SuperMovieServiceImplTestWithMocks {

	@Test()
	public void testFindMovies() {
		Mockery mockery = new Mockery();
		// création des objets bouchons
		final MovieDao dao1 = mockery.mock(MovieDao.class, "dao1");
		final MovieDao dao2 = mockery.mock(MovieDao.class, "dao2");

		// instanciation de SuperMovieServiceImpl avec injection des deux mocks
		SuperMovieServiceImpl service = new SuperMovieServiceImpl(
				Arrays.asList(dao1, dao2));
		mockery.checking(new Expectations() {
			{
				one(dao1).retrieve("a");
				will(returnValue(Arrays.asList(new Movie("aa", 1900), new Movie("za", 1950))));
				one(dao2).retrieve("a");
				will(returnValue(Arrays.asList(new Movie("ap", 1900), new Movie("ca", 1950))));
			}
		});

		
		List<Movie> movies = service.findMovies("a");
		mockery.assertIsSatisfied();
		Assert.assertEquals(4, movies.size());
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
		}
	}
}
