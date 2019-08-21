package com.example.bertonisolutions.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest {

	@Test
	public void compareLinesTest() {
		assertTrue(Main.compareHands("8C TS KC 9H 4S 7D 2S 5D 3S AC") == -1);
		assertTrue(Main.compareHands("5C AD 5D AC 9C 7C 5H 8D TD KS") > 0);
		assertTrue(Main.compareHands("3H 7H 6S KC JS QH TD JC 2D 8S") > 0);
		assertTrue(Main.compareHands("TH 8H 5C QS TC 9H 4D JC KS JS") == -1);
		assertTrue(Main.compareHands("7C 5H KC QH JD AS KH 4C AD 4S") < 0);
		assertTrue(Main.compareHands("5H KS 9C 7D 9H 8D 3S 5D 5C AH") > 0);
		assertTrue(Main.compareHands("6H 4H 5C 3H 2H 3S QH 5S 6S AS") > 0);

		assertTrue(Main.compareHands("TS JS QS KS AS 1S 2S 3S 4S 5S") > 0);
	}

	@Test
	public void showHelpTest() {
		Main.showHelp();
	}

	@Test
	public void getDefaultFileNameTest() {
		String fileName = FileUtils
				.getResourceCanonicalPath("/static/files/pokerdata.txt");
		System.out.println(fileName);
		assertNotNull(fileName);
	}

	@Test
	public void printResourceTest() {
		FileUtils.printResource("/static/files/pokerdata.txt");
	}
	

}
