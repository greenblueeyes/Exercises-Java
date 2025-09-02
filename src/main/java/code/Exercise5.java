package code;

import java.util.HashMap;
import java.util.Map;

public class Exercise5 {

    // Given a string s, return the longest palindromic substring in s.
    //
    // Example 1:
    // ---------
    // Input: s = "babad"
    // Output: "bab"
    // Explanation: "aba" is also a valid answer.
    //
    // Example 2:
    // ---------
    // Input: s = "cbbd"
    // Output: "bb"
    //
    // tattarrattat

    public static boolean isPalindrome(final String str) {
        boolean isPalindrome = true;
        int idxLeft = 0;
        int idxRight;

        if (str == null) {
            throw new IllegalArgumentException("Invalid string value provided");
        }
        if (str.isEmpty()) {
            return false;
        }
        idxRight = str.length() - 1;

        while (idxLeft < idxRight && isPalindrome) {
            isPalindrome = str.charAt(idxLeft++) == str.charAt(idxRight--);
        }
        return isPalindrome;
    }

    public static String findSubstringPalindrome(final String str) {
        int longestLength = 0;
        int idxLeft = 0;
        String longestSubstrKey = null;

        Map<String, Integer> palindromes = HashMap.newHashMap(100);

        while(idxLeft < str.length()) {
            int centeredStartIdx = isMatchingOutward(str, idxLeft - 1, idxLeft + 1);
            if (centeredStartIdx>= 0 && centeredStartIdx < idxLeft) {
                int subStringLen = ((idxLeft - centeredStartIdx) * 2) + 1;
                String key = String.format("%d|%d", centeredStartIdx, centeredStartIdx + ((idxLeft - centeredStartIdx) * 2));
                palindromes.put(key, subStringLen);
                if (longestLength < subStringLen) {
                    longestLength = subStringLen;
                    longestSubstrKey = key;
                }
            }

            int mirroredStartIdx = isMatchingOutward(str, idxLeft, idxLeft + 1);
            if (mirroredStartIdx >=0 && mirroredStartIdx <= idxLeft) {
                int subStringLen = (idxLeft - mirroredStartIdx + 1) * 2;
                String key = String.format("%d|%d", mirroredStartIdx, mirroredStartIdx + subStringLen - 1);
                palindromes.put(key, subStringLen);
                if (longestLength < subStringLen) {
                    longestLength = subStringLen;
                    longestSubstrKey = key;
                }
            }
            idxLeft++;
        }

        if (longestSubstrKey == null) {
            return null;
        } else {
            int idxDelim = longestSubstrKey.indexOf('|');
            int start = Integer.parseInt(longestSubstrKey.substring(0, idxDelim));
            int end = Integer.parseInt(longestSubstrKey.substring(idxDelim + 1));

            return str.substring(start, end + 1);
        }
    }

    static int isMatchingOutward(final String str, final int idxLeft, final int idxRight) {
        if (idxLeft < 0 || idxRight >= str.length()) {
            return idxLeft + 1;
        }

        if (str.charAt(idxLeft) == str.charAt(idxRight)) {
            return isMatchingOutward(str, idxLeft - 1, idxRight + 1);
        } else {
            return idxLeft+1;
        }
    }
}
