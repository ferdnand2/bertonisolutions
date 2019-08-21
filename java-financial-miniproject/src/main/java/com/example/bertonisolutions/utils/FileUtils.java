package com.example.bertonisolutions.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

	/**
	 * Gets the path given a resource file
	 * 
	 * @param resource Name of the file
	 * @return path.
	 */
	public static String getResourceCanonicalPath(String resource) {
		File file = new File(FileUtils.class.getResource(resource).getFile());
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Prints a resource. It is used for showing the help message
	 * 
	 * @param resource FIle to print
	 * @return true if successful. False otherwise
	 */
	public static boolean printResource(String resource) {
		try {
			File file = new File(FileUtils.class.getResource(resource)
					.getFile());
			try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
				stream.forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Prints the results in an output file.
	 * 
	 * @param outputFileName Name of the file to print
	 * @param winFirstPlayer Quantity of hands won by first player
	 * @param winSecondPlayer Quantity of hands won by second player
	 * @param draw Quantity of ties
	 * @return True if successful
	 */
	public static boolean printToOutputFile(String outputFileName,
			int winFirstPlayer, int winSecondPlayer, int draw) {
		try (FileWriter fw = new FileWriter(outputFileName)) {
			fw.write("1: "
					+ winFirstPlayer
					+ "\n2: "
					+ winSecondPlayer
					+ "\n3: "
					+ draw
					+ "\n4:\n---------PLAYER 1 --------- | ------ PLAYER 2 --------------\n"
					+ "         "
					+ String.format("%.2f", winFirstPlayer * 100.0
							/ (winFirstPlayer + winSecondPlayer + draw))
					+ "%             |         "
					+ String.format("%.2f", winSecondPlayer * 100.0
							/ (winFirstPlayer + winSecondPlayer + draw)) + "%");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
