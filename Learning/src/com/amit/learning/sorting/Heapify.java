package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;
import com.amit.learning.util.TreePrintUtil;

public class Heapify {

        public static void main(String[] args) {
            int[] heap = {3, 9, 2, 6, 8, 7, 10, 10, 1, 1002};
            int[] heapClone = heap.clone();
            int[] heap1 = {1,2,3,4,55,99,77,88,};
            buildMaxHeap(heap);
            buildMinHeap(heapClone);
        }

        // Heapify a subtree rooted at index i (assuming the subtrees are already heaps)
        static void buildMaxHeap(int[] heap) {
            int n = heap.length;

            // (n / 2) - 1 Because:
            //In a binary heap, all nodes from n/2 to n-1 are leaf nodes (they don’t have children).
            //We don’t need to heapify leaves.
            //So we start heapifying from the last parent node: i = n/2 - 1, and go up to the root (i = 0).
            // we have 10 elements it go upto max of 4 nodes only
            int startIdx = (n / 2) - 1;
            System.out.println(n+" is the length of the array and startIdx: " + startIdx);
            // Perform reverse level order traversal from last non-leaf node and heapify each node
            for (int i = startIdx; i >= 0; i--) {
                System.out.println("Running for: "+i);
                maxHeapify(heap, n, i);
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("After max heapify: ");

            System.out.println("----------------------------");

        }

    public static void buildMinHeap(int[] heap) {
        int n = heap.length;
        int startIdx = (n / 2) - 1;
        TreePrintUtil.printHeapAsTree(heap, 0, "", true);
        for (int i = startIdx; i >= 0; i--) {
            System.out.println("Running for: "+i);
            minHeapify(heap, n, i);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("After Min heapify: ");
        TreePrintUtil.printHeapAsTree(heap, 0, "", true);
    }

    static void maxHeapify(int[] heap, int size, int i) {
            int largestElementIndex = i;          // Initialize largest as root
            int leftElementIndex = 2 * i + 1;     // Left child index
            int rightElementIndex = 2 * i + 2;    // Right child index

            // If leftElement child is larger than root
            if (leftElementIndex < size && heap[leftElementIndex] > heap[largestElementIndex]) {
                largestElementIndex = leftElementIndex;
            }

            // If right child is larger than largest so far
            if (rightElementIndex < size && heap[rightElementIndex] > heap[largestElementIndex]) {
                largestElementIndex = rightElementIndex;
            }

            // If largest is not root
            if (largestElementIndex != i) {
                // Swap
                int temp = heap[i];
                heap[i] = heap[largestElementIndex];
                heap[largestElementIndex] = temp;

                // Recursively heapify the affected subtree
                maxHeapify(heap, size, largestElementIndex);
            }
            System.out.println("After heapify: ");
            PrintUtil.print(heap);
        }

    static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(arr, n, smallest);
        }

        System.out.println("After minHeapify: ");
        PrintUtil.print(arr);
    }


}
