package com.amit.learning.sliding_window;

import java.util.*;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // Shrink the window if we have more than k distinct chars
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(map);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "ecebae";
        int k = 2;
        int result = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println("Longest substring with at most " + k + " distinct characters: " + result);
    }
}
/***
 * Explanation of Important Parts:
 * Map<Character, Integer> map: Keeps track of how many times each character appears in the current window.
 *
 * left: Start of the sliding window.
 *
 * right: End of the sliding window.
 *
 * If map.size() > k, we shrink the window by moving left forward, reducing character counts.
 *
 * Always update maxLen to hold the length of the largest valid window seen so far.
 *
 * Time & Space Complexity:
 * Time: O(n), where n = length of the string.
 *
 * Space: O(k), for the character frequency map.
 *  * We need the longest substring with at most 2 distinct characters.
 *  *
 *  * Substrings:
 *  *
 *  * "ece" → has 2 distinct characters →  length 3
 *  *
 *  * "ec" → 2 distinct →  length 2
 *  *
 *  * "ceba" → has 3 distinct characters →
 *  *
 *  * So, the longest valid one is "ece" → length = 3
 * */
