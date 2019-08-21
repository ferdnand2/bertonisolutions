package com.example.bertonisolutions.utils;

import java.util.Arrays;

public class PokerUtils {

	public final static String HIGH_CARD = "0";
	public final static String ONE_PAIR = "1";
	public final static String TWO_PAIRS = "2";
	public final static String THREE_OF_A_KIND = "3";
	public final static String STRAIGHT = "4";
	public final static String FLUSH = "5";
	public final static String FULL_HOUSE = "6";
	public final static String FOUR_OF_A_KIND = "7";
	public final static String STRAIGHT_FLUSH = "8";
	public final static String ROYAL_FLUSH = "9";

	public static String valueHand(String[] cards) {

		orderCards(cards);
		if (isFlushHand(cards) && isStraightHand(cards) && isMinCardTen(cards)) {
			return ROYAL_FLUSH;
		}
		if (isFlushHand(cards) && isStraightHand(cards)) {
			return STRAIGHT_FLUSH + getMaxCard(cards);
		}
		String fourOfAKind = getFourOfAKind(cards);
		if (fourOfAKind != null) {
			return FOUR_OF_A_KIND + fourOfAKind;
		}

		String fullHouse = getFullHouse(cards);
		if (fullHouse != null) {
			return FULL_HOUSE + fullHouse;
		}
		if (isFlushHand(cards)) {
			return FLUSH + orderCards(cards);
		}
		if (isStraightHand(cards)) {
			return STRAIGHT + getMaxCard(cards);
		}
		String threeOfAKind = getThreeOfAKind(cards);
		if (threeOfAKind != null) {
			return THREE_OF_A_KIND + threeOfAKind;
		}
		String twoPairs = getTwoPairs(cards);
		if (twoPairs != null) {
			return TWO_PAIRS + twoPairs;
		}
		String onePair = getOnePair(cards);
		if (onePair != null) {
			return ONE_PAIR + onePair;
		}

		return HIGH_CARD + getStringValueFromCard(cards, 4)
				+ getStringValueFromCard(cards, 3) + getStringValueFromCard(cards, 2)
				+ getStringValueFromCard(cards, 1) + getStringValueFromCard(cards, 0);
	}

	private static String getOnePair(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 1)) {
			return getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 3)
					+ getStringValueFromCard(cardsPlayer, 2);
		}
		if (getValueFromCard(cardsPlayer, 1) == getValueFromCard(cardsPlayer, 2)) {
			return getValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 3)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		if (getValueFromCard(cardsPlayer, 2) == getValueFromCard(cardsPlayer, 3)) {
			return getStringValueFromCard(cardsPlayer, 3)
					+ getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		if (getValueFromCard(cardsPlayer, 3) == getValueFromCard(cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		return null;
	}

	private static String getTwoPairs(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 1)
				&& getValueFromCard(cardsPlayer, 2) == getValueFromCard(
						cardsPlayer, 3)) {
			return getStringValueFromCard(cardsPlayer, 3)
					+ getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 4);
		}
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 1)
				&& getValueFromCard(cardsPlayer, 3) == getValueFromCard(
						cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 2);
		}
		if (getValueFromCard(cardsPlayer, 1) == getValueFromCard(cardsPlayer, 2)
				&& getValueFromCard(cardsPlayer, 3) == getValueFromCard(
						cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		return null;
	}

	private static String getThreeOfAKind(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 2)) {
			return getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 3);
		}
		if (getValueFromCard(cardsPlayer, 1) == getValueFromCard(cardsPlayer, 3)) {
			return getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 4)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		if (getValueFromCard(cardsPlayer, 2) == getValueFromCard(cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		return null;
	}

	private static String getFullHouse(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 2) == getValueFromCard(cardsPlayer, 4)
				&& getValueFromCard(cardsPlayer, 0) == getValueFromCard(
						cardsPlayer, 1)) {
			return getStringValueFromCard(cardsPlayer, 2)
					+ getStringValueFromCard(cardsPlayer, 1);
		}
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 2)
				&& getValueFromCard(cardsPlayer, 3) == getValueFromCard(
						cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 0)
					+ getStringValueFromCard(cardsPlayer, 3);
		}
		return null;
	}

	private static String getFourOfAKind(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 1) == getValueFromCard(cardsPlayer, 4)) {
			return getStringValueFromCard(cardsPlayer, 1)
					+ getStringValueFromCard(cardsPlayer, 0);
		}
		if (getValueFromCard(cardsPlayer, 0) == getValueFromCard(cardsPlayer, 3)) {
			return getStringValueFromCard(cardsPlayer, 0)
					+ getStringValueFromCard(cardsPlayer, 4);
		}
		return null;
	}

	private static int getMaxCard(String[] cardsPlayer) {
		return getValueFromCard(cardsPlayer, 4);
	}

	private static boolean isMinCardTen(String[] cardsPlayer) {
		return getValueFromCard(cardsPlayer, 0) == 10;
	}

	private static String orderCards(String[] cardsPlayer) {
		Arrays.sort(
				cardsPlayer,
				(String a, String b) -> getValueFromCard(a) < getValueFromCard(b) ? -1
						: getValueFromCard(a) == getValueFromCard(b) ? 0 : 1);
		return null;
	}

	private static boolean isStraightHand(String[] cardsPlayer) {
		if (getValueFromCard(cardsPlayer, 0) == 14
				&& getValueFromCard(cardsPlayer, 1) == 2
				&& getValueFromCard(cardsPlayer, 2) == 3
				&& getValueFromCard(cardsPlayer, 3) == 4
				&& getValueFromCard(cardsPlayer, 4) == 5) {
			return true;
		}

		int base = getValueFromCard(cardsPlayer, 0);
		for (int i = 1; i < cardsPlayer.length; i++) {
			if (getValueFromCard(cardsPlayer, i) != base + i) {
				return false;
			}
		}
		return true;
	}

	private static int getValueFromCard(String[] cardsPlayer, int numberOfCard) {
		return getValueFromCard(cardsPlayer[numberOfCard]);

	}

	private static int getValueFromCard(String cardsPlayer) {
		char character = cardsPlayer.charAt(0);
		if (character == 'A') {
			return 14;
		} else if (character == 'K') {
			return 13;
		} else if (character == 'Q') {
			return 12;
		} else if (character == 'J') {
			return 11;
		} else if (character == 'T') {
			return 10;
		}
		return Integer.parseInt(character + "");

	}
	
	private static String getStringValueFromCard(String[] cardsPlayer,  int numberOfCard) {
		char character = cardsPlayer[numberOfCard].charAt(0);
		if (character == 'A') {
			return "E";
		} else if (character == 'K') {
			return "D";
		} else if (character == 'Q') {
			return "C";
		} else if (character == 'J') {
			return "B";
		} else if (character == 'T') {
			return "A";
		}
		return String.valueOf(character) ;

	}

	private static boolean isFlushHand(String[] cardsPlayer) {
		char flushPropposed = cardsPlayer[0].charAt(1);
		for (int i = 1; i < cardsPlayer.length; i++) {
			if (cardsPlayer[i].charAt(1) != flushPropposed) {
				return false;
			}
		}
		return true;
	}
}
