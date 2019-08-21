package com.example.bertonisolutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.example.bertonisolutions.utils.FileUtils;
import com.example.bertonisolutions.utils.PokerUtils;

public class Main {

	public final static String HELP = "-help";

	/**
	 * Main method of the application
	 * @param args Args of the application
	 */
	public static void main(String... args) {
		run(args);
	}

	/**
	 * Method to run the program. Opens the given input file, process it and finally print the results in the otput file.
	 * 
	 * @param args Args
	 */
	static void run(String... args) {
		String inputFileName = null;
		String outputFileName = null;
		if (args.length == 1) {
			outputFileName = args[0];
		} else if (args.length == 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		} else {
			showHelp();
		}
		process(inputFileName, outputFileName);
	}

	/**
	 * Process the input file and wrtie the results in the output one.
	 * 
	 * @param inputFileName Name of the input file.
	 * @param outputFileName Name of the output file.
	 */
	private static void process(String inputFileName, String outputFileName) {
		int winFirstPlayer = 0;
		int winSecondPlayer = 0;
		int draw = 0;
		if (inputFileName == null) {
			inputFileName = FileUtils
					.getResourceCanonicalPath("/static/files/pokerdata.txt");
			if (inputFileName == null) {
				System.out.println("Error loading default input file");
			} 
		} 
		try (FileReader fr = new FileReader(inputFileName);
				BufferedReader br = new BufferedReader(fr)) {
			String hands;
			while ((hands = br.readLine()) != null) {
				int result = compareHands(hands);
				if (result > 0) {
					winFirstPlayer++;
				} else if (result < 0) {
					winSecondPlayer++;
				} else {
					draw++;
				}
			}			
			FileUtils.printToOutputFile(outputFileName, winFirstPlayer,
					winSecondPlayer, draw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Compare the hands of the players to determinate the winner.
	 * @param line Line of the read file
	 * @return 1 if the winner is te first player, -1 if the winner is the second player. 0 if no one wins.
	 */
	public static int compareHands(String line) {
		int endOfFirstPlayer = 5 * 2 + 4;
		String lineFirstPlayer = line.substring(0, endOfFirstPlayer);
		String lineSecondPlayer = line.substring(endOfFirstPlayer + 1);
		String[] cardsFirstPlayer = lineFirstPlayer.split(" ");
		String[] cardsSecondPlayer = lineSecondPlayer.split(" ");
		String valueFirstPlayer = PokerUtils.evaluateHand(cardsFirstPlayer);
		String valueSecondPlayer = PokerUtils.evaluateHand(cardsSecondPlayer);
		System.out.println(valueFirstPlayer + "/" + valueSecondPlayer);
		return valueFirstPlayer.compareTo(valueSecondPlayer);
	}

	/**
	 * Show the help message
	 * 
	 * @return True if sucess
	 */
	public static boolean showHelp() {
		return FileUtils.printResource("/static/files/help.txt");
	}

}
