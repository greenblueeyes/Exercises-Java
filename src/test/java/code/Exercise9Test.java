package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise9Test {

    private final Exercise9 ex9 = new Exercise9();

    @Test
    void testSolve_simple_palindrome() {
        Assertions.assertTrue(ex9.solve(121));
    }

    @Test
    void testSolve_negative() {
        Assertions.assertFalse(ex9.solve(-121));
    }

    @Test
    void testSolve_simple_not_palindrome() {
        Assertions.assertFalse(ex9.solve(10));
    }

    @Test
    void testSolve_single_digit() {
        Assertions.assertTrue(ex9.solve(8));
    }
}