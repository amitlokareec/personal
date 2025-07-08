package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

/**
 * Counting Sort is a non-comparison-based sorting algorithm used for sorting integers within a known range,
 * typically small or moderate in size.
 *
 * It doesn’t compare elements like QuickSort or HeapSort.
 * It counts occurrences of each element using a temporary array.
 * It works best when:
 * The input values are non-negative integers.
 * The maximum value (k) is not significantly larger than the number of elements (n).
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Step 1: Find max value
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        System.out.println("Found max: " + max);

        // Step 2: Create count array
        int[] count = new int[max + 1];
        System.out.print("created empty array called Count Array: ");
        PrintUtil.print(count);
        for (int num : arr) {
            count[num]++;
        }
        System.out.print("Counting filled with how many times that respective value is found in the array. Count Array: ");
        PrintUtil.print(count);

        // Step 3: Modify count array to store cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        System.out.print("Add each value in the array and fill the count. Count Array: ");
        PrintUtil.print(count);

        // Step 4: Build output array
        int[] output = new int[arr.length];
        System.out.print("Created an empty output Array.");
        PrintUtil.print(output);
        for (int i = arr.length - 1; i >= 0; i--) {//starting from behind of the orig array and going backwards
            int val = arr[i];
            System.out.println("count[val]: "+count[val]+". output[count[val] - 1]: "+(output[count[val] - 1])+". val: "+val);
            output[count[val] - 1] = val;//output is full empty so everytime you get 0 only
            System.out.println("output[count[val]-1]: "+output[count[val]-1]);
            count[val]--;
        }
        PrintUtil.print(output);
        // Step 5: Copy back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        System.out.print("Input data: ");
        PrintUtil.print(data);
        countingSort(data);

        System.out.print("Sorted array: ");
        PrintUtil.print(data);
    }
}
