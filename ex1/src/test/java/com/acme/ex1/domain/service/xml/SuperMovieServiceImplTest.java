package com.acme.ex1.domain.service.xml;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.ex1.domain.entity.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/acme/ex1/context/appCtx.xml")
public class SuperMovieServiceImplTest {

	@Inject
	private SuperMovieServiceImpl service;

	@Test()
	public void testFindMovies() {
		List<Movie> movies = service.findMovies("a");
		Assert.assertNotNull(movies);
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
		}
	}

	public static void main(String[] args) throws Throwable {
		String testClassName = "com.acme.ex1.domain.service.xml.SuperMovieServiceImplTest";
		Class<?> clazz = Class.forName(testClassName);
		Object testInstance = clazz.newInstance();
		if (!clazz.isAnnotationPresent(ContextConfiguration.class))
			return;
		ContextConfiguration conf = clazz
				.getAnnotation(ContextConfiguration.class);
		System.out.println(conf.locations()[0]);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				conf.locations());
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				System.out.println(field.getName());
				field.set(testInstance, ctx.getBean(field.getType()));
			}
		}
		for(Method method : clazz.getDeclaredMethods())
		{
			if(method.isAnnotationPresent(Test.class))
			{
				Test test = method.getAnnotation(Test.class);
				try
				{
					method.invoke(testInstance);
					System.out.println("ok");
				}
				catch(Exception e)
				{
					if(e.getCause().equals(test.expected()))
					{
						System.out.println("ok");
					}
				}
			}
		}

		// 1. Charger le contexte
		// 2. fixer une valeur pour les champs annotés par @Inject
		// 3. Invoquer les méthodes annotées par @Test

	}
}
