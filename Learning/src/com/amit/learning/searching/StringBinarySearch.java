package com.amit.learning.searching;

import java.util.Arrays;

public class StringBinarySearch {

    public static int binarySearch(String[] arr, String target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = target.compareTo(arr[mid]);

            if (comparison == 0) {
                return mid;
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "mango", "peach"};
        String target = "mango";

        long startBinary = System.nanoTime();
        int binaryResult = binarySearch(words, target);
        long endBinary = System.nanoTime();

        if (binaryResult != -1) {
            System.out.println("Word found at index: " + binaryResult);
        } else {
            System.out.println("Word not found.");
        }
        if (binaryResult != -1) {
            System.out.println("Binary Search: Word found at index: " + binaryResult);
        } else {
            System.out.println("Binary Search: Word not found.");
        }
        System.out.println("Binary Search Time (ns): " + (endBinary - startBinary));
    }
}

