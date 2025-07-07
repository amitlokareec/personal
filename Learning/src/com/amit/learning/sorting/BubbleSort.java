package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        PrintUtil.print(arr);
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{9,5, 3, 4,4, 6, 3, 2, 7});
    }
}
