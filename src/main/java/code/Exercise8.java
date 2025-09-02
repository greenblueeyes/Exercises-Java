package code;

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {
     // https://leetcode.com/problems/string-to-integer-atoi
     //
     // Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
     //
     // The algorithm for myAtoi(string s) is as follows:
     //
     // Whitespace: Ignore any leading whitespace (" ").
     // Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
     // Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
     // Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
     // Return the integer as the final result.
     //
     // Example 1:
     // ---------
     // Input: s = "42"
     // Output: 42
     //
     // Explanation:
     //
     // The underlined characters are what is read in and the caret is the current reader position.
     // Step 1: "42" (no characters read because there is no leading whitespace)
     //          ^
     // Step 2: "42" (no characters read because there is neither a '-' nor '+')
     //          ^
     // Step 3: "42" ("42" is read in)
     //            ^
     // Example 2:
     // ----------
     // Input: s = " -042"
     // Output: -42
     //
     // Explanation:
     //
     // Step 1: "   -042" (leading whitespace is read and ignored)
     //             ^
     // Step 2: "   -042" ('-' is read, so the result should be negative)
     //              ^
     // Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
     //                ^
     // Example 3:
     // -----------
     // Input: s = "1337c0d3"
     // Output: 1337
     //
     // Explanation:
     //
     // Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
     //          ^
     // Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
     //          ^
     // Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
     //              ^
     // Example 4:
     // ----------
     // Input: s = "0-1"
     // Output: 0
     //
     // Explanation:
     //
     // Step 1: "0-1" (no characters read because there is no leading whitespace)
     //          ^
     // Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
     //          ^
     // Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
     //           ^
     // Example 5:
    // ------------
     // Input: s = "words and 987"
     // Output: 0
     //
     //* Explanation:
     //*
     //* Reading stops at the first non-digit character 'w'.
    //
    // Constraints:
    //
    // 0 <= s.length <= 200
    // s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
   //
     static class ModifyValue {
        enum Decimal_Place {
            ONES (1, 0),
            TENS (10, 1),
            HUNDREDS (100, 2),
            THOUSANDS (1_000, 3),
            TEN_THOUSANDS (10_000, 4),
            HUNDRED_THOUSANDS (100_000, 5),
            MILLIONS (1_000_000, 6),
            TEN_MILLIONS (10_000_000, 7),
            HUNDRED_MILLIONS (100_000_000, 8);

            final int multiplier;
            final int exponent;

            /**
             *
             * @param multiplier
             * @param exp exponent represent decimal place (10^x)
             */
            Decimal_Place(final int multiplier, final int exp) {
                this.multiplier = multiplier;
                this.exponent = exp;
            }

            static Decimal_Place parseInt(final int mx) {
                for (final Decimal_Place value: Decimal_Place.values()) {
                    if (mx == value.multiplier) {
                        return value;
                    }
                }
                return null;
            }

            static Decimal_Place findByExponent(final int exponent) {
                for (final Decimal_Place value: Decimal_Place.values()) {
                    if (exponent == value.exponent) {
                        return value;
                    }
                }
                return null;
            }
        }

        private Decimal_Place decimalPlace = Decimal_Place.ONES;
        private final int digit;

        ModifyValue(int num) {
            this.digit = num;
        }

        public void setDecimalPlace(final Decimal_Place mx) {
            this.decimalPlace = mx;
        }

        public int modifyValue(int value) {
            return value + (this.digit * decimalPlace.multiplier);
        }
    }

    public int myAtoI(final String toConvert) {
        boolean intCharsFirst = false;
        boolean charsFirst = false;
        boolean negative = false;
        int charsStartIdx = -1;

        int idx = 0;
        int reversal = 0;

        final List<ModifyValue> modifications = new ArrayList<>(toConvert.length());

        while (idx < toConvert.length() && charsStartIdx < 0) {
            char chr = toConvert.charAt(idx);

            if (Character.isDigit(chr)) {
                if (!intCharsFirst && !charsFirst) {
                    intCharsFirst = true;
                }
                modifications.add(new ModifyValue((int) chr - 48));
            } else if (Character.isAlphabetic(chr)) {
                charsStartIdx = idx;
                if (!intCharsFirst && !charsFirst) {
                    // no other non-whitespace chars so far
                    // starting with word char
                    charsFirst = true;
                }
            } else if (Character.isSpaceChar(chr)) {
                //ignore
            } else if (chr == '-') {
                if (!intCharsFirst && !charsFirst) {
                    // no other non-whitespace chars so far
                    // char is negative sign
                    negative = true;
                } else if (intCharsFirst) {
                    // '-' is in wrong place; cannot be negative sign
                    // treated like alphabetic char
                    charsStartIdx = idx;
                }
            }

            idx++;
        }

        if (!modifications.isEmpty()) {
            int decimalPlaces = modifications.size() - 1;
            for (final ModifyValue modify: modifications) {
                ModifyValue.Decimal_Place dp =
                        ModifyValue.Decimal_Place.findByExponent(decimalPlaces);
                if (dp == null) {
                    throw new ArithmeticException("invalid decimal place value: " + Math.pow(10, decimalPlaces));
                }
                modify.setDecimalPlace(dp);
                reversal = modify.modifyValue(reversal);
                decimalPlaces--;
            }
        }
        return negative? (-reversal) : reversal;
    }
}
