package com.amit.learning.sliding_window;

public class MaximumSumOfaSubarray {
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSumSubarray(nums, k));
    }
}
