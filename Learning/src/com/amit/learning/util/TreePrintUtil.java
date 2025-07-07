package com.amit.learning.util;

public class TreePrintUtil {

    public static void printHeapAsTree(int[] arr, int index, String indent, boolean isLast) {
        if (index >= arr.length) return;

        System.out.print(indent);
        if (index == 0) {
            System.out.println(arr[index]);
        } else {
            System.out.print(isLast ? "R── " : "L── ");
            System.out.println(arr[index]);
        }

        indent += isLast ? "    " : "│   ";

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < arr.length)
            printHeapAsTree(arr, leftIndex, indent, false);

        if (rightIndex < arr.length)
            printHeapAsTree(arr, rightIndex, indent, true);
    }
}
