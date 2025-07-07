package com.amit.learning.sorting;

import com.amit.learning.util.PrintUtil;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        mergeSort(new int[]{77,2,1,7}, 4);
    }

    private static void mergeSort(int[] arr, int completeArrayLength) {
        if (completeArrayLength <= 1) return ;

        int mid = completeArrayLength/2;

        int righttLen = completeArrayLength-mid;
        int leftLen = mid;
        int[] left = new int[leftLen];
        int[] right = new int[righttLen];

        /**
         * Dividing here to left and right and hence logn
         */
        for (int i = 0; i < leftLen; i++) {
            left[i] = arr[i];
        }//prepare left array
        for (int i = righttLen; i < completeArrayLength; i++) {
            right[i-mid] = arr[i];
        }//prepare right array

        mergeSort(left, mid);
        mergeSort(right, arr.length-mid);
        merge(arr, left, right, leftLen, righttLen);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftLength, int rightMidToRightLength) {
        System.out.println("Left: " + Arrays.toString(leftArr) + " Right: " + Arrays.toString(rightArr) + " arr:"+Arrays.toString(arr) + " leftLength: " + leftLength + " rightMidToRightLength: " + rightMidToRightLength);
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightMidToRightLength) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightMidToRightLength) {
            arr[k++] = rightArr[j++];
        }
        /**
         * Why 3 while loops?
         *
         * Let’s say:
         * leftArr = [2, 6, 9]
         * rightArr = [1, 4]
         * Merge begins:
         *
         * 2 > 1 → arr = [1]
         *
         * 2 < 4 → arr = [1, 2]
         *
         * 6 > 4 → arr = [1, 2, 4]
         *
         * Now j == rightMidToRightLength (rightArr is exhausted), so the first while loop ends.
         *
         * But leftArr still has [6, 9] leftLength. So now we need:
         * 
         * while (i < leftLength) {
         *     arr[k++] = leftArr[i++];
         * }
         * To copy the remaining elements → Final merged: [1, 2, 4, 6, 9]
         *
         * All elements are run n times
         *
         * hence, toal O(nlogn)
         */
        System.out.println();
        System.out.print("Merged the Arr--->");
        PrintUtil.print(arr);
    }

}
/***
 * Stack for the input mergeSort(new int[]{77,2,1,7}, 4);
 *
 * mergeSort([77,2,1,7])  ← root call
 * |
 * ├── mergeSort([77,2])          ← Line A
 * │   |
 * │   ├── mergeSort([77])        ← Line A
 * │   └── mergeSort([2])         ← Line B
 * │   └── merge([77], [2])       ← Line C
 * |
 * └── mergeSort([1,7])           ← Line B
 *     |
 *     ├── mergeSort([1])         ← Line A
 *     └── mergeSort([7])         ← Line B
 *     └── merge([1], [7])        ← Line C
 *
 * → merge([2,77], [1,7])         ← Line C
 *
 *
 * 1. mergeSort({77,2,1,7,8,5,4,3}, 8)
 *     A. mergeSort({77,2,1,7}, 4)
 *         A. mergeSort({77,2}, 2)
 *             A. mergeSort({77}, 1)  return
 *             B. mergeSort({2}, 1)  return
 *             C. merge {77} + {2} → {2,77}
 *         B. mergeSort({1,7}, 2)
 *             A. mergeSort({1}, 1) 
 *             B. mergeSort({7}, 1) 
 *             C. merge {1} + {7} → {1,7}
 *         C. merge {2,77} + {1,7} → {1,2,7,77}
 *     B. mergeSort({8,5,4,3}, 4)
 *         A. mergeSort({8,5}, 2)
 *             A. mergeSort({8}, 1) 
 *             B. mergeSort({5}, 1) 
 *             C. merge {8} + {5} → {5,8}
 *         B. mergeSort({4,3}, 2)
 *             A. mergeSort({4}, 1) 
 *             B. mergeSort({3}, 1) 
 *             C. merge {4} + {3} → {3,4}
 *         C. merge {5,8} + {3,4} → {3,4,5,8}
 *     C. merge {1,2,7,77} + {3,4,5,8} → {1,2,3,4,5,7,8,77}
 *
 */