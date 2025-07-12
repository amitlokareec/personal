package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

import java.util.Arrays;

public class RadixSortStrings {

    public static void radixSort(String[] arr, int maxLen) {
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            countingSortByChar(arr, pos);
        }
    }

    private static void countingSortByChar(String[] strArr, int pos) {
        System.out.println("pos: "+pos);
        System.out.print("Input: ");
        PrintUtil.print(strArr);
        int strArrLen = strArr.length;
        int[] count = new int[256]; // ASCII range allocated here

        for (String s : strArr) {
            int charIndex = s.charAt(pos);//ex: at abc, xyz for pos 2 will find c and z, pos 1 it willfind b and y and so on
            count[charIndex]++;
        }
        System.out.print("******* Count Array: ");
        PrintUtil.print(count);

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        System.out.print("Updated Count Array: ");
        PrintUtil.print(count);

        String[] output = new String[strArrLen];
        for (int i = strArrLen - 1; i >= 0; i--) {//Runs only for 6 times as our array is 6 here
            int charIndex = strArr[i].charAt(pos);
            System.out.println(strArr[i].charAt(pos)+"------------------"+charIndex+"--------------"+count[charIndex]);
            output[--count[charIndex]] = strArr[i];
            PrintUtil.print(output);
        }
        System.out.print("Output Array: ");
        PrintUtil.print(output);

        System.arraycopy(output, 0, strArr, 0, strArrLen);
    }

    public static void main(String[] args) {
        String[] arr = {"bca", "acb", "abc", "bac", "cab", "cba"};
        int maxLen = arr[0].length(); // Assuming equal length
        radixSort(arr, maxLen);

        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
