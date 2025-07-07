package org.dataflx;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AlgorithmRepository
{
    /*=================================
            Searching Algorithms
    ===================================*/
    // Sequential (Linear) search
    public static int sequentialSearch(List<Double> arr, double key) {
        int arrayLength = arr.size();
        arr.add(key);
        int i = 0;

        while (arr.get(i) != key) { i++; }

        arr.removeLast();

        return (i == arrayLength) ? -1 : i;
    }

    // Binary search
    public static int binarySearch(List<Double> arr, double key) {
        //Clone the original array
        List<Double> clonedArray = new ArrayList<>(arr);

        // First sort the array
        Collections.sort(arr);

        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = (int) Math.floor((double)(low + high) / 2);
            double guess = arr.get(mid);

            if (guess == key) {
                return AlgorithmRepository.sequentialSearch(clonedArray, arr.get(mid));
            } else if (guess < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*=================================
            Sorting Algorithms
    ===================================*/
    // Bubble Sort Algorithm
    public static String bubbleSort(List<Double> arr) {
        int n = arr.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    double num = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, num);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        return arr.toString();
    }

}