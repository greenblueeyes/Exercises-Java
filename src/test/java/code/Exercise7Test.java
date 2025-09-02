package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise7Test {
    private final Exercise7 ex7 = new Exercise7();

    @Test
    void testSolve_321() {
        Assertions.assertEquals(123, ex7.solve(321));
    }

    @Test
    void testSolve_negative_123() {
        Assertions.assertEquals(-321, ex7.solve(-123));
    }

    @Test
    void testSolve_numberEndsWithZero_120() {
        Assertions.assertEquals(21, ex7.solve(120));
    }
}
