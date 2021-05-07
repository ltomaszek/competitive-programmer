package section2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    int[][] maxKingsData;

    @BeforeEach
    void setUp() {
        maxKingsData = new int[][] {
                new int[] {1, 1, 0},    // nurRows, numColumns, expected result
                new int[] {3, 3, 8},
                new int[] {6, 3, 16},
                new int[] {2, 3, 5},
                new int[] {4, 4, 12},
                new int[] {4, 5, 16},
        };
    }

    @Test
    void testMaxKings() {
        for (int[] data : maxKingsData) {
            int numRows = data[0];
            int numColumns = data[1];
            int expectedOutput = data[2];

            assertEquals(expectedOutput, King.maxKings(numRows, numColumns));
        }
    }
}