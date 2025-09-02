package code;

import java.util.Arrays;

public class Exercise9 {

    // https://leetcode.com/problems/palindrome-number
    //
    // Given an integer x, return true if x is a palindrome, and false otherwise.
    //
    // Example 1:
    // ---------
    // Input: x = 121
    // Output: true
    // Explanation: 121 reads as 121 from left to right and from right to left.
    //
    // Example 2:
    // ---------
    // Input: x = -121
    // Output: false
    // Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    //
    // Example 3:
    // ---------
    // Input: x = 10
    // Output: false
    // Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    //
    // Constraints:
    //
    // -2^31 <= x <= 2^31 - 1
    //
    // Follow up: Could you solve it without converting the integer to a string?

    final int[] decimalPlaces = new int[] {
            1,
            10,
            100,
            1_000,
            10_000,
            100_000,
            1_000_000,
            10_000_000,
            100_000_000,
            1_000_000_000,
    };

    public boolean solve(final int input) {
        return input >= 0 && isNumericPalindrome(input);
    }

    public boolean isNumericPalindrome(final int input) {
        final int[] inputDigits;
        // check for single digit
        if (0 <= input && input < 10) {
            return true;
        }
        inputDigits = iToIntArray(input);
        return isIntPalindrome(inputDigits);
    }

    int[] iToIntArray(final int input) {
        // 321
        // find number of decimal places
        int maxDpIndex = decimalPlaces.length - 1;
        int digitIdx = 0;
        int inputInWork = input;
        int[] digits;

        while (decimalPlaces[maxDpIndex] > input) {
            maxDpIndex--;
        }

        digits = new int[maxDpIndex + 1];
        Arrays.fill(digits, '0');

        // break int down into individual digits
        while (maxDpIndex >= 0) {
            int digit = Math.floorDiv(inputInWork, decimalPlaces[maxDpIndex]);
            inputInWork -= digit * decimalPlaces[maxDpIndex];
            digits[digitIdx] = digit;
            maxDpIndex--;
            digitIdx++;
        }

        return digits;
    }

    boolean isIntPalindrome(final int[] digits) {
        boolean isPalindrome = true;
        int startIdx = 0;
        int endIdx = digits.length - 1;

        while (isPalindrome && startIdx < endIdx) {
            isPalindrome = (digits[startIdx] == digits[endIdx]);
            startIdx++;
            endIdx--;
        }

        return isPalindrome;
    }
}
