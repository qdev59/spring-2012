package com.acme.ex1.domain.dao.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.acme.ex1.domain.dao.MovieDao;
import com.acme.ex1.domain.entity.Movie;

class WarnerMovieDaoImpl implements MovieDao {

	private String filename;

	WarnerMovieDaoImpl(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public List<Movie> retrieve(String name) {
		try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
			String keyword = name.toLowerCase();
			ArrayList<Movie> movies = new ArrayList<>(); // opérateur diamant, inférence de type. Nouveauté java 7
			String line;
			while ((line = reader.readLine()) != null) {
				String[] columns = line.split(";");
				String title = columns[0];
				if (title.toLowerCase().contains(keyword)) {
					Movie movie = new Movie(title, Integer.parseInt(columns[1]));
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
