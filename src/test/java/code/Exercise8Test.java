package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise8Test {
    private final Exercise8 ex8 = new Exercise8();

    @Test
    void testSolve_42() {
        Assertions.assertEquals(42, ex8.myAtoI("42"));
    }

    @Test
    void testSolve_space_negative_leading_zero_42() {
        Assertions.assertEquals(-42, ex8.myAtoI(" -042"));
    }

    @Test
    void testSolve_alphabetic_chars_after_number() {
        Assertions.assertEquals(1337, ex8.myAtoI("1337c0d3"));
    }

    @Test
    void testSolve_symbol_after_number() {
        Assertions.assertEquals(0, ex8.myAtoI("0-1"));
    }

    @Test
    void testSolve_starts_with_words() {
        Assertions.assertEquals(0, ex8.myAtoI("words and 987"));
    }
}