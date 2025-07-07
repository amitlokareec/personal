package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;
import com.amit.learning.util.Util;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    Util.swap(arr, j, i);
                }
            }
        }
        PrintUtil.print(arr);
    }

    public static void main(String[] args) {
        selectionSort(new int[]{9,5, 3, 4,4, 6, 3, 2, 7});
    }
}
