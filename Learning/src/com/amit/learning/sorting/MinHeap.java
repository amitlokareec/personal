package com.amit.learning.sorting;

import com.amit.learning.util.TreePrintUtil;

public class MinHeap {

        public static void main(String[] args) {
            int[] heap = {3, 9, 2, 6, 8, 7, 10, 10, 1, 1002};
            int n = heap.length;
            int startIdx = (n / 2) - 1;

            for (int i = startIdx; i >= 0; i--) {
                Heapify.minHeapify(heap, n, i);
            }

            System.out.print("Min Heap: ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            TreePrintUtil.printHeapAsTree(heap, 0, "", true);
        }

    }


