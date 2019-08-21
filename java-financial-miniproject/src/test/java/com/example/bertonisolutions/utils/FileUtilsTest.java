package com.example.bertonisolutions.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void getDefaultFileNameTest() {
		String fileName = FileUtils
				.getResourceCanonicalPath("/static/files/pokerdata.txt");
		System.out.println(fileName);
		assertNotNull(fileName);
	}

	@Test
	public void printResourceTest() {
		assertTrue(FileUtils.printResource("/static/files/pokerdata.txt"));
	}
	
	@Test
	public void printToOutputFileTest() {
		assertTrue(FileUtils.printToOutputFile("output.txt", 10, 10, 0)); 
	}

}
