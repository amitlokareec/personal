package com.amit.learning.sorting;

import com.amit.learning.util.TreePrintUtil;
import com.amit.learning.util.Util;

public class HeapSortOrMaxHeap {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            Heapify.maxHeapify(arr, n, i);
        }

        // Step 2: One by one extract elements
        for (int i = n - 1; i >= 1; i--) {
            // Move current root to end
            Util.swap(arr, 0, i);

            // Call heapify on reduced heap
            Heapify.maxHeapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] heap = new int[]{3,7,1,2,4,77,88,1232,5};
        heapSort(heap);
        TreePrintUtil.printHeapAsTree(heap, 0, "", true);
    }
}
