package section1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StraightFlush {

    public static String[] convertToCards(String s) {
        Set<Character> validDigits = new HashSet<>(
                Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
        Set<Character> validRanks = new HashSet<>(
                Arrays.asList('C', 'D', 'H', 'S'));

        String[] cards = s.split(" ");
        Set<String> seenCards = new HashSet<>();
        if (cards.length != 5) {
            throw new IllegalArgumentException("Invalid cards representation");
        }
        for (String card : cards) {
            if (card.length() != 2 || !validDigits.contains(card.charAt(0))
                    || !validRanks.contains(card.charAt(1)) || seenCards.contains(card)) {
                throw new IllegalArgumentException("Invalid cards representation");
            }
            else {
                seenCards.add(card);
            }
        }
        return cards;
    }

    public static boolean isStraightFlush(String[] cards) {
        boolean isAce = false;
        char suit = getSuit(cards[0]);
        byte minRank = Byte.MAX_VALUE;
        byte maxRank = Byte.MIN_VALUE;
        for (String card : cards) {
            if (suit != getSuit(card))
                return false;
            if (isAce(card)) {
                isAce = true;
            } else {
                byte rank = getNumericRank(card);
                minRank = (byte)Math.min(minRank, rank);
                maxRank = (byte)Math.max(maxRank, rank);
            }
        }
        if (isAce) {
            if (maxRank - minRank > 3)
                return false;
            else {
                return minRank == 2 || maxRank == 13;
            }
        } else {
            return maxRank - minRank == 4;
        }
    }

    private static char getSuit(String card) {
        return card.charAt(1);
    }

    private static byte getNumericRank(String card) {
        switch (card.charAt(0)) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 1;
        }
        return (byte)Character.getNumericValue(card.charAt(0));
    }

    private static boolean isAce(String card) {
        return card.charAt(0) == 'A';
    }
}
