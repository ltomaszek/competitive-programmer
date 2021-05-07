package section1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {

    String[] validCards;
    String[] invalidCards;
    String[] straightFlush;
    String[] notStraightFlush;

    @BeforeEach
    void setUp() {
        validCards = new String[] {
            "2D 5D 3D 4D 6D", "AD KH QH JS TC"
        };
        invalidCards = new String[] {
            "KH QH JS TC", "2G 5D 3D 4D 6D", "2d 5D 3D 4D 6D", "2D 5D 1D 4D 6D", "2d 5D 3D 4D 10D", "2D 2D 3D 4D 6D"
        };
        straightFlush = new String[] {
            "2D 5D 3D 4D 6D", "2D 5D 3D 4D AD", "9H QH KH TH JH", "AH QH KH TH JH"
        };
        notStraightFlush = new String[] {
            "2D 5D 3D 4D 7D", "6D 5D 3D 4D AD", "8H QH KH TH JH", "AH QH KH 9H JH"
        };
    }

    @Test
    void testConvertToCardsWithInvalidString() {
        for (String cardStr : invalidCards) {
            assertThrows(IllegalArgumentException.class, () -> StraightFlush.convertToCards(cardStr));
        }
    }

    @Test
    void testConvertToCardsWithValidString() {
        for (String cardStr : validCards) {
            assertTrue(StraightFlush.convertToCards(cardStr).length == 5);
        }
    }

    @Test
    void testIsStraightFlushTrue() {
        for (String cardStr : straightFlush) {
            System.out.println(cardStr);
            assertTrue(StraightFlush.isStraightFlush(StraightFlush.convertToCards(cardStr)));
        }
    }

    @Test
    void testIsStraightFlushFalse() {
        for (String cardStr : notStraightFlush) {
            assertFalse(StraightFlush.isStraightFlush(StraightFlush.convertToCards(cardStr)));
        }
    }

    @Test
    void testPerformance() {
        String cardStr = straightFlush[0];
        int REPEAT = 1_000_000;

        long runtime = testRuntime(() -> {
            for (int i = 0; i < REPEAT; i++)
                StraightFlush.isStraightFlush(StraightFlush.convertToCards(cardStr));
        });

        // Runtime should be less than 3 seconds
        assertTrue(runtime * 1e-9 < 3);
    }

    private long testRuntime(Runnable r) {
        long startTime = System.nanoTime();
        r.run();
        return System.nanoTime() - startTime;
    }
}