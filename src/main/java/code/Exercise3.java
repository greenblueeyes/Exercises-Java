package code;

import java.util.*;

public class Exercise3 {
    public static class Result {
        private final String subStr;
        private final int len;

        public Result(final String subString) {
            this.subStr = subString;
            this.len = subString.length();
        }

        public String getSubString() {
            return subStr;
        }

        public int length() {
            return len;
        }

        public static Result empty() {
            return new Result("");
        }
    }

    //
    // Given a string s, find the length of the longest substring without duplicate characters.
    //
    // Example 1:
    // ---------
    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    //
    // Example 2:
    // ---------
    // Input: s = "bbbbb"
    // Output: 1
    // Explanation: The answer is "b", with the length of 1.
    //
    // Example 3:
    // ---------
    // Input: s = "pwwkew"
    // Output: 3
    // Explanation: The answer is "wke", with the length of 3.
    // Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    ///

    public Result findNonRepeatingSubstring(final String input) {
        String longestSubStr = "";
        StringBuilder currSubStrBldr = new StringBuilder(input.length());
        Map<Character, Integer> strChars = new HashMap<>(128);

        if (input == null || input.isEmpty()) {
            return Result.empty();
        }

        int idx = 0;

        while (idx < input.length()) {
            char chr = input.charAt(idx);

            if (strChars.containsKey(chr)) {
                // handle end of substr
                String tmp = currSubStrBldr.toString();
                if (tmp.length() > longestSubStr.length()) {
                    longestSubStr = tmp;
                }
                currSubStrBldr = new StringBuilder(input.length());
                strChars.clear();
            }

            // add char to stack
            // add char to map
            strChars.put(chr, idx);
            currSubStrBldr.append(chr);

            idx++;
        }

        return new Result(longestSubStr);
    }
}
