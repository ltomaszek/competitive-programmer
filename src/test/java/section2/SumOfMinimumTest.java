package section2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfMinimumTest {

    Object[][] inOutData;

    @BeforeEach
    void setUp() {
        inOutData = new Object[][] {
                new Object[] {new int[]{5, 2}, 9},
                new Object[] {new int[]{3, 1, 2, 3}, 16},
                new Object[] {new int[]{1, 1, 1, 1, 1, 2}, 22}
        };
    }

    @Test
    void testCalculateMinSumOnSubsets() {
        for (Object[] data : inOutData) {
            int[] input = (int[]) data[0];
            int expectedOutput = (Integer) data[1];

            assertEquals(expectedOutput, SumOfMinimum.calculateMinSumOnSubsets(input));
        }
    }
}