package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;
import com.amit.learning.util.Util;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // pivot index
            quickSort(arr, low, pi - 1);  // Left of pivot
            quickSort(arr, pi + 1, high); // Right of pivot
        }
    }

    private static int partition(int[] arr, int low, int high) {
        System.out.println("high element: " + high + "... low element: " + low + "...");
        int pivot = arr[high]; // pivot is last element
        int i = low - 1;       // smaller element index

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                Util.swap(arr, i, j); // move smaller to left
            }
        }

        Util.swap(arr, i + 1, high); // place pivot in correct spot
        System.out.println("After partition: ");
        PrintUtil.print(arr);
        return i + 1;           // return pivot index
    }

    public static void main(String[] args) {
        int [] arr =new int[]{9,5, 3, 4,4, 6, 3, 2, 0};
        int [] arr1 =new int[]{1,2,3,4,5,6,0};
        System.out.print("Input ---> ");
        PrintUtil.print(arr);
        quickSort(arr, 0, arr.length-1);
        PrintUtil.print(arr);
    }
}
