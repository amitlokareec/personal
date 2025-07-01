package com.amit.learning.searching;

public class LinearSearch {
    public static int linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "mango", "peach"};
        String target = "mango";

        long startLinear = System.nanoTime();
        int linearResult = linearSearch(words, target);
        long endLinear = System.nanoTime();

        if (linearResult != -1) {
            System.out.println("Linear Search: Word found at index: " + linearResult);
        } else {
            System.out.println("Linear Search: Word not found.");
        }
        System.out.println("Linear Search Time (ns): " + (endLinear - startLinear));
    }
}
