package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

/**
 * Radix Sort is a non-comparison-based sorting algorithm that sorts numbers digit by digit,
 * starting either from the least significant digit (LSD) or most significant digit (MSD).
 * It doesn't use <, >, or == comparisons between the elements themselves — which is why it can outperform traditional
 * comparison sorts like MergeSort and QuickSort when used correctly.
 * Let's say you want to sort:

 * int[] a = {170, 45, 75, 90, 802, 24, 2, 66};
 * We sort based on digits:
 *
 * 1st pass (units place) → sort by last digit:
 * → [170, 90, 802, 2, 24, 45, 75, 66]
 *
 * 2nd pass (tens place):
 * → [802, 2, 24, 45, 66, 170, 75, 90]
 *
 * 3rd pass (hundreds place):
 * → [2, 24, 45, 66, 75, 90, 170, 802]  Sorted!
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        System.out.print("input Array: ");
        PrintUtil.print(arr);
        int max = getMax(arr);
        System.out.println("max: "+max);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            System.out.println("exp: "+exp);
            countingSortByDigit(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr)
            if (i > max)
                max = i;
        return max;
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int arrLen = arr.length;
        int[] output = new int[arrLen];
        int[] count = new int[10]; // digits 0-9

        for (int i = 0; i < arrLen; i++) {
            int digit = (arr[i] / exp) % 10;
            System.out.println("digit: "+digit+" arr[i]: "+arr[i]+" count: "+count[digit]);
            count[digit]++;//couting the digit occurence
        }
        System.out.print("Count Array: ");
        PrintUtil.print(count);
        // Prefix sum for stable sort
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build output (stable sort, go from right to left)
        for (int i = arrLen - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, arrLen);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
       PrintUtil.print(arr);
    }
}
