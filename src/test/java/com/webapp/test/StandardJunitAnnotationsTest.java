package com.webapp.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardJunitAnnotationsTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("-- Before all ---");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("-- After all ---");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("-- Before each setup ---");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("-- After each cleanup ---");
	}
	
	@Test
	public void testOne() {
		System.out.println("Test One executed !");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Test Two executed !");
	}
	
	@Test
	public void testThree() {
		System.out.println("Test Three executed !");
	}
}
