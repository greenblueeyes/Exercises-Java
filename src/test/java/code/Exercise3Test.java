package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise3Test {
    private final Exercise3 x3 = new Exercise3();

    @Test
    void testFindLongestNonRepeatingSubstring_case_1() {
         var result = x3.findNonRepeatingSubstring("abcabcbb");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("abc", result.getSubString());
        Assertions.assertEquals(3, result.length());
    }

    @Test
    void testFindLongestNonRepeatingSubstring_case_2() {
        var result = x3.findNonRepeatingSubstring("bbbbb");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("b", result.getSubString());
        Assertions.assertEquals(1, result.length());
    }

    @Test
    void testFindLongestNonRepeatingSubstring_case_3() {
        var result = x3.findNonRepeatingSubstring("pwwkew");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("wke", result.getSubString());
        Assertions.assertEquals(3, result.length());
    }
}
