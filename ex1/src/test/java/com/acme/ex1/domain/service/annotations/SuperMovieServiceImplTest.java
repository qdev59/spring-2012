package com.acme.ex1.domain.service.annotations;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.ex1.domain.entity.Movie;
import com.acme.ex1.domain.service.MovieService;

public class SuperMovieServiceImplTest {

	@Test()
	public void testFindMovies() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/acme/ex1/context/appCtxAnnotations.xml");
		MovieService service = (MovieService) ctx.getBean("superMovieServiceImpl");
		List<Movie> movies = service.findMovies("a");
		Assert.assertNotNull(movies);
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
		}
	}

}
