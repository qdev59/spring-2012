package com.acme.ex3a.utils;

import java.lang.reflect.Field;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class MyDatasource extends BasicDataSource {

	public void setProperties(Properties props) throws Exception {

		Class<BasicDataSource> clazz = BasicDataSource.class;

		for (Entry<Object, Object> entry : props.entrySet()) {

			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			try {
				Field field = clazz.getDeclaredField(key);
				if (field.getType().equals(int.class)) {
					field.setInt(this, Integer.parseInt(value));
				} else if (field.getType().equals(long.class)) {
					field.setLong(this, Long.parseLong(value));
				} else if (field.getType().equals(boolean.class)) {
					field.setBoolean(this, Boolean.parseBoolean(value));
				} else {
					field.set(this, value);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
