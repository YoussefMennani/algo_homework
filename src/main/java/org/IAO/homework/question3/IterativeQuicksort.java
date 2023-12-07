package org.IAO.homework.question3;

import java.util.Stack;

public class IterativeQuicksort {

    public static void quicksort(Comparable[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }

        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;

        stack.push(0);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int partitionIndex = partition(arr, low, high);

            if (partitionIndex - 1 > low) {
                stack.push(low);
                stack.push(partitionIndex - 1);
            }

            if (partitionIndex + 1 < high) {
                stack.push(partitionIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(Comparable[] arr, int low, int high) {
        int pivot = high;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (less(arr[j],arr[pivot])) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, pivot);
        return i + 1;
    }

/*    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }*/

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    private static void printArray(Comparable[] arr) {
        for (Comparable element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] testArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("Original Array:");
        printArray(testArray);

        quicksort(testArray);

        System.out.println("\nSorted Array:");
        printArray(testArray);
    }
}

