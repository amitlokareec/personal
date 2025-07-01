package com.amit.learning.sliding_window;

public class LongestOnesWithKFlips {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeros = 0, maxLen = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            // Shrink window from the left if zeros > k
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        int k = 2;
        System.out.println("Longest subarray of 1s after flipping at most " + k + " zeros: " + longestOnes(nums, k));
    }
}
/**
 * I thot 10 is wrong it should be 4. As after flipping 0 to 1s for max k times we get 4
 *
 *
 * ChatGPT said:
 * Great question — but let's walk through it carefully, because the correct answer is actually 10, not 4. Let me show you why.
 *
 * Input
 * java
 * Copy
 * Edit
 * nums = {1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
 * k = 2
 * Problem Statement Recap
 * You're allowed to flip at most k = 2 zeros to 1, and you're supposed to find the longest contiguous subarray containing only 1s (after at most 2 flips).
 *
 * Sliding Window Example
 * Let’s simulate the sliding window logic:
 *
 * Start from the beginning: [1, 1] — good (0 zeros).
 *
 * Add 0 → [1, 1, 0] — still good (1 zero).
 *
 * Add another 0 → [1, 1, 0, 0] — still valid (2 zeros).
 *
 * Add third 0 → now window becomes [1, 1, 0, 0, 0] — 3 zeros → too many. Shrink from the left.
 *
 * Start shrinking:
 *
 * Remove 1 → still 3 zeros.
 *
 * Remove next 1 → still 3 zeros.
 *
 * Remove 0 → now 2 zeros, valid window again.
 *
 * Window is now:
 *
 * text
 * Copy
 * Edit
 * [0, 1, 1, 1, 1, 1, 1, 1]  ← length 8
 * Still valid (2 zeros). Keep going:
 *
 * Add next 1 → length 9
 *
 * Add next 1 → length 10 ← this is the max
 *
 * Final Answer: 10
 * This subarray is:
 *
 * text
 * Copy
 * Edit
 * [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
 *           ↑ 2 flipped zeros
 *
 *
 * **/
