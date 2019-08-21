package com.example.bertonisolutions.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public final static String HELP = "-help";

	public static void main(String... args) {
		String inputFileName = null;
		String outputFileName;
		if (args.length == 1) {
			outputFileName = args[0];
		} else if (args.length == 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		} else {
			showHelp();
			return;
		}
		process(inputFileName, outputFileName);
	}

	private static void process(String inputFileName, String outputFileName) {
		int winFirstPlayer = 0;
		int winSecondPlayer = 0;
		int draw = 0;
		if (inputFileName == null) {
			inputFileName = FileUtils
					.getResourceCanonicalPath("/static/files/pokerdata.txt");
			if (inputFileName == null) {
				System.out.println("Error loading default input file");
				return;
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
			System.out.println(winFirstPlayer + "-" + winSecondPlayer + "-"
					+ draw);
			printToOutputFile(outputFileName, winFirstPlayer, winSecondPlayer,
					draw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printToOutputFile(String outputFileName,
			int winFirstPlayer, int winSecondPlayer, int draw) {
		try {
			FileWriter fw = new FileWriter(outputFileName);
			fw.write("1: "
					+ winFirstPlayer
					+ "\n2: "
					+ winSecondPlayer
					+ "\n3: "
					+ draw
					+ "\n4:\n---------PLAYER 1 --------- | ------ PLAYER 2 --------------\n"
					+ "         XX.XX%             |         XX.XX%");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}

	static int compareHands(String line) {
		int endOfFirstPlayer = 5 * 2 + 4;
		String lineFirstPlayer = line.substring(0, endOfFirstPlayer);
		String lineSecondPlayer = line.substring(endOfFirstPlayer + 1);
		String[] cardsFirstPlayer = lineFirstPlayer.split(" ");
		String[] cardsSecondPlayer = lineSecondPlayer.split(" ");
		String valueFirstPlayer = PokerUtils.valueHand(cardsFirstPlayer);
		String valueSecondPlayer = PokerUtils.valueHand(cardsSecondPlayer);
		System.out.println(valueFirstPlayer + "/" + valueSecondPlayer);
		return valueFirstPlayer.compareTo(valueSecondPlayer);
	}

	static void showHelp() {
		FileUtils.printResource("/static/files/help.txt");
	}

}
