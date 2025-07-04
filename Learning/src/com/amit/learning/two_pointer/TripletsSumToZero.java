package com.amit.learning.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Triplets That Sum to Zero
 * Given an array nums, find all unique triplets (a, b, c) such that:
 * a + b + c == 0
 * and the triplets are returned without duplicates
 *
 * Example:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 */
public class TripletsSumToZero {
    public static List<List<Integer>> tripletsSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate 'i' elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers and skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need a larger value
                } else {
                    right--; // Need a smaller value
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = tripletsSum(nums);

        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
