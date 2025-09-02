package code;

import java.math.BigInteger;
import java.util.Arrays;

public class Exercise7 {
    /**
     * https://leetcode.com/problems/reverse-integer
     *
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     *
     *
     * Example 1:
     * ---------
     * Input: x = 123
     * Output: 321
     *
     * Example 2:
     * ---------
     * Input: x = -123
     * Output: -321
     *
     * Example 3:
     * ---------
     * Input: x = 120
     * Output: 21
     *
     *
     * Constraints:
     *
     * -2^31 <= x <= 2^31 - 1
     */
    int[] tenPowers = new int[] {
        1,
        10,
        100,
        1_000,
        10_000,
        100_000,
        1_000_000,
        10_000_000,
        100_000_000,
        1_000_000_000
    };

    public int solve(final int toReverse) {
        int toReverseInwork = Math.abs(toReverse);

        int idxPower = tenPowers.length - 1;
        while (toReverseInwork < tenPowers[idxPower]) {
            idxPower--;
        }

        int decimalPlace = 1;
        int reversal = 0;
        while (idxPower >= 0) {
            int digit = Math.floorDiv(toReverseInwork, (int) tenPowers[idxPower]);
            reversal += digit * decimalPlace;
            toReverseInwork -= (digit * tenPowers[idxPower]);
            decimalPlace *= 10;
            idxPower--;
        }

        int reverse = 0;
        try {
            reverse = (toReverse < 0 ) ? Math.negateExact(reversal) : reversal;
        } catch (final ArithmeticException e) {
            //ignore overflow of int
        }
        return reverse;
    }

    public int solveStringConversion(final int toReverse) {
        int reverse = 0;
        int toReverseInwork = toReverse;

        int idxPower = tenPowers.length - 1;
        while (toReverse < tenPowers[idxPower]) {
            idxPower--;
        }

        char[] reversal = new char[idxPower + 1];
        Arrays.fill(reversal, '0');

        while(idxPower >= 0) {
            int digit = Math.floorDiv(toReverseInwork, (int) tenPowers[idxPower]);
            reversal[idxPower] = (char) (digit + 48);
            toReverseInwork -= (digit * tenPowers[idxPower]);
            idxPower--;
        }

        reverse = Integer.parseInt(String.valueOf(reversal));

        return (toReverse < 0 ) ? Math.negateExact(reverse): reverse;
    }
}
