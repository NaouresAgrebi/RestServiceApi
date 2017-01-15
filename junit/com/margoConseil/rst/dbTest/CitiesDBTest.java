package com.margoConseil.rst.dbTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class CitiesDBTest {

	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		// db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("resource/db/create-db.sql")
				.addScript("resource/db/insert-data.sql").build();
	}

	@Test
	public void testFindByname() {

	}

	@After
	public void tearDown() {
		db.shutdown();
	}

}
