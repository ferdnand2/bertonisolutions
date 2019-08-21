package com.example.bertonisolutions.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

	static String getResourceCanonicalPath(String resource) {
		File file = new File(Main.class.getResource(resource).getFile());
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			return null;
		}
	}

	public static void printResource(String resource) {
		try {
			File file = new File(Main.class.getResource(resource).getFile());
			// read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
				stream.forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
