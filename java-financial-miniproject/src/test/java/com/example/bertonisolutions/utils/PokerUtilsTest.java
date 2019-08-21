package com.example.bertonisolutions.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PokerUtilsTest {

	@Test
	public void valueHandTest() {
		assertEquals(PokerUtils.evaluateHand(new String[]{"8C","TS","KC","9H","4S"}), "0DA984");
		assertEquals(PokerUtils.evaluateHand(new String[]{"5C","AD","5D","AC","9C"}), "2E59");
		assertEquals(PokerUtils.evaluateHand(new String[]{"3H","7H","6S","KC","JS"}), "0DB763");
		assertEquals(PokerUtils.evaluateHand(new String[]{"TH","8H","5C","QS","TC"}), "1AC85");
		assertEquals(PokerUtils.evaluateHand(new String[]{"7C","5H","KC","QH","JD"}), "0DCB75");
		assertEquals(PokerUtils.evaluateHand(new String[]{"5H","KS","9C","7D","9H"}), "19D75");
		assertEquals(PokerUtils.evaluateHand(new String[]{"6H","4H","5C","3H","2H"}), "46");
		assertEquals(PokerUtils.evaluateHand(new String[]{"TS","JS","QS","KS","AS"}), "9");
	}

	@Test
	public void getOnePairTest() {		
		assertEquals(PokerUtils.getOnePair(new String[]{"2S", "2C", "3C", "4C", "5S"}), "2543");
		assertEquals(PokerUtils.getOnePair(new String[]{"2C", "3C", "3C", "5C", "6S"}), "3652");
		assertEquals(PokerUtils.getOnePair(new String[]{"2C", "3C", "4C", "4C", "6S"}), "4632");
		assertNull(PokerUtils.getOnePair(new String[]  {"2C", "3C", "4C", "6C", "7S"}), null);
	}

	@Test
	public void getTwoPairsTest() {		
		assertEquals(PokerUtils.getTwoPairs(new String[]{"2S", "2C", "3C", "4C", "4S"}), "423");
		assertEquals(PokerUtils.getTwoPairs(new String[]{"2C", "3C", "3C", "5C", "5S"}), "532");
		assertEquals(PokerUtils.getTwoPairs(new String[]{"2C", "2C", "4C", "4C", "6S"}), "426");
		assertNull(PokerUtils.getTwoPairs(new String[]  {"2C", "3C", "4C", "6C", "7S"}), null);
	}

	@Test
	public void getThreeOfAKindTest() {		
		assertEquals(PokerUtils.getThreeOfAKind(new String[]{"2S", "2C", "2C", "4C", "5S"}), "254");
		assertEquals(PokerUtils.getThreeOfAKind(new String[]{"2C", "3C", "3C", "3C", "5S"}), "352");
		assertEquals(PokerUtils.getThreeOfAKind(new String[]{"2C", "3C", "4C", "4C", "4S"}), "432");
		assertNull(PokerUtils.getThreeOfAKind(new String[]  {"2C", "3C", "4C", "6C", "7S"}), null);
	}
	
	@Test
	public void getFullHouseTest() {		
		assertEquals(PokerUtils.getFullHouse(new String[]{"2S", "2C", "2C", "4C", "4S"}), "24");
		assertEquals(PokerUtils.getFullHouse(new String[]{"2C", "2C", "3C", "3C", "3S"}), "32");
		assertNull(PokerUtils.getFullHouse(new String[]  {"2C", "3C", "4C", "6C", "7S"}), null);
	}
	
	@Test
	public void getFourOfAKindTest() {		
		assertEquals(PokerUtils.getFourOfAKind(new String[]{"2S", "2C", "2C", "2C", "4S"}), "24");
		assertEquals(PokerUtils.getFourOfAKind(new String[]{"2C", "3C", "3C", "3C", "3S"}), "32");
		assertNull(PokerUtils.getFourOfAKind(new String[]  {"2C", "3C", "4C", "6C", "7S"}), null);
	}
	
	@Test
	public void getMaxCardTest() {		
		assertEquals(PokerUtils.getMaxCard(new String[]{"2S", "2C", "2C", "2C", "4S"}), 4);
		assertEquals(PokerUtils.getMaxCard(new String[]{"2C", "3C", "3C", "3C", "3S"}), 3);
		assertEquals(PokerUtils.getMaxCard(new String[]{"2C", "3C", "3C", "3C", "JS"}), 11);
		assertEquals(PokerUtils.getMaxCard(new String[]{"2C", "3C", "3C", "KC", "AS"}), 14);
	}	

	@Test
	public void  isMinCardTenTest() {
		assertEquals(PokerUtils.isMinCardTen(new String[]{"2S", "3C", "5C", "9C", "QS"}), false);
		assertEquals(PokerUtils.isMinCardTen(new String[]{"2S", "3C", "5C", "9C", "QS"}), false);
		assertEquals(PokerUtils.isMinCardTen(new String[]{"2S", "3C", "5C", "9C", "QS"}), false);
		assertEquals(PokerUtils.isMinCardTen(new String[]{"2S", "3C", "5C", "9C", "QS"}), false);
		assertEquals(PokerUtils.isMinCardTen(new String[]{"TS", "3C", "5C", "9C", "QS"}), true);
	}

	@Test
	public void  orderCardsTest() {
		assertArrayEquals(PokerUtils.orderCards(new String[]{"6S", "3C", "5C", "4C", "QS"}), new String[]{"3C", "4C", "5C", "6S", "QS"});
		assertArrayEquals(PokerUtils.orderCards(new String[]{"AS", "TC", "4C", "2C", "KS"}), new String[]{"2C", "4C", "TC", "KS", "AS"});
	}

	@Test
	public void  isStraightHandTest() {
		assertEquals(PokerUtils.isStraightHand(new String[]{"2S", "3C", "4C", "5C", "6S"}), true);
		assertEquals(PokerUtils.isStraightHand(new String[]{"2S", "3C", "4C", "5C", "7S"}), false);
		assertEquals(PokerUtils.isStraightHand(new String[]{"AS", "2C", "3C", "4C", "5S"}), true);
		assertEquals(PokerUtils.isStraightHand(new String[]{"AS", "2C", "3C", "4C", "6S"}), false);
		assertEquals(PokerUtils.isStraightHand(new String[]{"TS", "JC", "QC", "KC", "AS"}), true);
		assertEquals(PokerUtils.isStraightHand(new String[]{"9S", "JC", "QC", "KC", "AS"}), false);
		assertEquals(PokerUtils.isStraightHand(new String[]{"TS", "TC", "QC", "KC", "AS"}), false);
	} 
	
	@Test
	public void  getValueFromCardTest() {
		assertEquals(PokerUtils.getValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 0), 2);
		assertEquals(PokerUtils.getValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 1), 3);
		assertEquals(PokerUtils.getValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 2), 5);
		assertEquals(PokerUtils.getValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 3), 9);
		assertEquals(PokerUtils.getValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 4), 12);		

		assertEquals(PokerUtils.getValueFromCard("2S"), 2);
		assertEquals(PokerUtils.getValueFromCard("3S"), 3);
		assertEquals(PokerUtils.getValueFromCard("4S"), 4);
		assertEquals(PokerUtils.getValueFromCard("5S"), 5);
		assertEquals(PokerUtils.getValueFromCard("6S"), 6);
		assertEquals(PokerUtils.getValueFromCard("7S"), 7);
		assertEquals(PokerUtils.getValueFromCard("8S"), 8);
		assertEquals(PokerUtils.getValueFromCard("9S"), 9);
		assertEquals(PokerUtils.getValueFromCard("TS"), 10);
		assertEquals(PokerUtils.getValueFromCard("JS"), 11);
		assertEquals(PokerUtils.getValueFromCard("QS"), 12);
		assertEquals(PokerUtils.getValueFromCard("KS"), 13);
		assertEquals(PokerUtils.getValueFromCard("AS"), 14);
	}

	@Test
	public void  getStringValueFromCardTest() {
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 0), "2");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 1), "3");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 2), "5");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 3), "9");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "TS"}, 4), "A");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "JS"}, 4), "B");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "QS"}, 4), "C");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "KS"}, 4), "D");
		assertEquals(PokerUtils.getStringValueFromCard(new String[]{"2S", "3C", "5C", "9C", "AS"}, 4), "E");
	}	

	@Test
	public void  isFlushHandTest() {
		assertEquals(PokerUtils.isFlushHand(new String[]{"2S", "3S", "5S", "9S", "QS"}), true);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2C", "3C", "5C", "9C", "QC"}), true);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2D", "3D", "5D", "9D", "QD"}), true);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2H", "3H", "5H", "9H", "QH"}), true);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2C", "3S", "5S", "9S", "QS"}), false);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2C", "3C", "5C", "9C", "QD"}), false);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2D", "3D", "5H", "9D", "QD"}), false);
		assertEquals(PokerUtils.isFlushHand(new String[]{"2H", "3C", "5H", "9H", "QH"}), false);
	}

}
