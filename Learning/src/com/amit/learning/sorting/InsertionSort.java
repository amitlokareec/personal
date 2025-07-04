package com.amit.learning.sorting;

public class InsertionSort {
    private static void insertionSort(int[] arr) {
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

        System.out.println("-----" + java.util.Arrays.toString(arr));
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        insertionSort(new int[]{100,99,-51,8,5,4,2,3,9,6,7});
    }
}


