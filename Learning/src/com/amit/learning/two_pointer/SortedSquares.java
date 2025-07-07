package com.amit.learning.two_pointer;

import com.amit.learning.util.PrintUtil;

import java.util.Arrays;

/**
 * To square a sorted array and return a new array with the squares in sorted order,
 * you can use a two-pointer approach which considers a sorted array as input.
 * This is an optimal solution with O(n) time complexity and is more efficient than
 * squaring and then sorting (which is O(n log n))
 */
public class SortedSquares {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            pos--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {-25, -7, -3, 0, 1,2, 5,18};
        int[] squaredSorted = sortedSquares(input);
        System.out.print("Sorted squares: ");
        PrintUtil.print(squaredSorted);
    }
}
/**
 * Given a sorted array (can include negative numbers), return a new sorted array of the squares.
 *
 * Two-pointer approach idea:
 * Start with two pointers: left at the beginning and right at the end.
 *
 * The largest square will be at either end (since negative numbers squared become large).
 *
 * Fill the result array from the end (highest index) to the start.
 *
 * Below is the 2 pointer technique:-
 *  while (left <= right) {
 *             int leftSquare = nums[left] * nums[left];
 *             int rightSquare = nums[right] * nums[right];
 */
