package com.acme.ex1.domain.dao.xml;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.entity.Movie;

class FoxMovieDaoImpl implements MovieDao {

	private String filename;
	
	FoxMovieDaoImpl(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public List<Movie> retrieve(String name) {
		try {
								 // Files.readAllLines : nouveauté java 7
			List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
			String keyword = name.toLowerCase();
			ArrayList<Movie> movies = new ArrayList<>(); // opérateur diamant, inférence de type. Nouveauté java 7
			for (String line : lines) {
				String[] columns = line.split("-");
				String title = columns[1];
				if(title.toLowerCase().contains(keyword))
				{
					Movie movie = new Movie(title, Integer.parseInt(columns[0]));
					movies.add(movie);
				}
			}
			movies.trimToSize();
			return movies;
		} catch (IOException e) {
			throw new RuntimeException(e); // wrapping d'exception
		}
	}

}
