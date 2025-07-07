package org.dataflx;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AlgorithmRepository
{
    //------------------------------------------------------------------------------
    //                              Searching Algorithms
    //------------------------------------------------------------------------------
    /*******************************************
            Sequential (Linear) search
     ******************************************/
    public static int sequentialSearch(List<Double> arr, double key) {
        int arrayLength = arr.size();
        arr.add(key);
        int i = 0;

        while (arr.get(i) != key) { i++; }

        arr.removeLast();

        return (i == arrayLength) ? -1 : i;
    }

    /*******************************************
            Binary (Linear) search
     ******************************************/
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


    //------------------------------------------------------------------------------
    //                              Sorting Algorithms
    //------------------------------------------------------------------------------
    /*******************************************
                    Bubble sort
     ******************************************/
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

    /*******************************************
                    Quick sort
     ******************************************/
    public static String quickSort(List<Double> arr, int low, int high) {
        //Set the initial high and low values
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

        return arr.toString();
    }

    private static int partition(List<Double> arr, int low, int high) {
        double pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                double temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        double temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    /*******************************************
                    Insertion sort
     ******************************************/
    public static String insertionSort(List<Double> arr) {
        for(int i = 1; i < arr.size(); ++i) {
            double prevElem = arr.get(i);
            int j;
            for(j = i - 1; j >= 0 && arr.get(j) > prevElem; --j) {
                arr.set(j + 1, arr.get(j));
            }
            arr.set(j + 1, prevElem);
        }
        return arr.toString();
    }


}