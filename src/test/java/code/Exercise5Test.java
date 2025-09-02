package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Exercise5Test {
    @ParameterizedTest()
    @ValueSource(strings = {"madam", "tattarrattat", "bob"})
    void testIsPalindrome(final String str) {
        Assertions.assertTrue(Exercise5.isPalindrome(str));
    }

    @ParameterizedTest
    @NullSource
    void testIsPalindrome_invalidInput_null(String str) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Exercise5.isPalindrome(str));
    }

    @ParameterizedTest
    @EmptySource
    void testIsPalindrome_invalidInput_empty(final String str) {
        Assertions.assertFalse(Exercise5.isPalindrome(str));
    }

    @Test
    void testLongestPalindromeSubstring_xyzmadamabc() {
        Assertions.assertEquals("madam", Exercise5.findSubstringPalindrome("xyzmadamabc"));
    }

    @Test
    void testLongestPalindromeSubstring_babad() {
        Assertions.assertEquals("bab", Exercise5.findSubstringPalindrome("babad"));
    }

    @Test
    void testLongestPalindromeSubstring_cbbd() {
        Assertions.assertEquals("bb", Exercise5.findSubstringPalindrome("cbbd"));
    }
}
