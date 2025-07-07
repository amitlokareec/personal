package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];      // current value to insert
            int j = i - 1;

            // Shift elements that are greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;  // Insert key at correct position
        }

        PrintUtil.print(arr);
    }

    public static void main(String[] args) {
        insertionSort(new int[]{100,99,-51,8,5,4,2,3,9,6,7});
    }
    /**
     * Space Complexity
     * No extra data structures used (like arrays or lists).
     *
     * Uses only a few extra variables (key, i, j).
     *
     * So, Space Complexity = O(1) (constant space).
     *
     * Time Complexity
     * Case	Explanation	Time
     * Best Case	Array is already sorted → only one comparison per i	O(n)
     * Average Case	Random input → shifting occurs regularly	O(n²)
     * Worst Case	Reversed array → maximum shifting needed	O(n²)
     *
     * So, Time Complexity = O(n²) (in general).
     */
}


