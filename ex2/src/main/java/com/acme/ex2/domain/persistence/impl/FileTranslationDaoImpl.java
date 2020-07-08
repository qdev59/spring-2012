package com.acme.ex2.domain.persistence.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

import com.acme.ex2.domain.persistence.TranslationDao;

public class FileTranslationDaoImpl implements TranslationDao {

	private String filepath;

	public FileTranslationDaoImpl(String folder, String filename) {
		super();
		this.filepath = Paths.get(folder, filename).toString();
	}

	@Override
	public String getTranslation(String in) {
		try (BufferedReader r = new BufferedReader(new FileReader(this.filepath))){
			String key = in + ";";
			String line;
			String result = null;
			while ((line = r.readLine()) != null && result == null) {
				if (line.startsWith(key)) {
					result = line.substring(line.indexOf(";") + 1);
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}