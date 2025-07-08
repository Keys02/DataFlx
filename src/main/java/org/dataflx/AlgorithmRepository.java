package org.dataflx;

import java.util.*;

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

    /*******************************************
                    Merge sort
     ******************************************/
    private static void merge(List<Double> arr, int low, int mid, int high) {
        ArrayList<Double> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr.get(left) <= arr.get(right)) {
                temp.add(arr.get(left));
                left++;
            } else {
                temp.add(arr.get(right));
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr.get(left));
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr.get(right));
            right++;
        }

        // Transferring all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr.set(i, temp.get(i - low));
        }
    }

    public static String mergeSort(List<Double> arr, int low, int high) {
        if (low >= high) { return null; }
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
        return arr.toString();
    }


    /*******************************************
                    Heap sort
     ******************************************/
    public static String heapSort(List<Double> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            double temp = arr.getFirst();
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0);
        }
        return arr.toString();
    }

    private static void heapify(List<Double> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr.get(left) > arr.get(largest)) {
            largest = left;
        }
        if (right < n && arr.get(right) > arr.get(largest))
            largest = right;
        if (largest != i) {
            double swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            heapify(arr, n, largest);
        }
    }

    /*******************************************
                    Radix sort
     ******************************************/
    private static final int SCALING_FACTOR = 1000; // for 3 decimal places

    // Get the maximum number
    public static int getMax(List<Integer> arr) {
        int max = arr.getFirst();
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }

    // Counting sort for digit place
    public static void countingSort(List<Integer> arr, int exp) {
        int n = arr.size();
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr.get(i) / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr.get(i) / exp) % 10;
            output.set(count[digit] - 1, arr.get(i));
            count[digit]--;
        }

        for (int i = 0; i < n; i++)
            arr.set(i, output.get(i));
    }

    // Radix sort for integers
    public static void radixSortInt(List<Integer> arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }

    // Main radix sort for doubles
    public static String radixSort(List<Double> doubleList) {
        int n = doubleList.size();
        ArrayList<Integer> scaled = new ArrayList<>();

        // Scale doubles to integers
        for (double d : doubleList)
            scaled.add((int) Math.round(d * SCALING_FACTOR));

        // Sort scaled integers
        radixSortInt(scaled);

        // Convert back to doubles
        for (int i = 0; i < n; i++)
            doubleList.set(i, scaled.get(i) / (double) SCALING_FACTOR);

        return doubleList.toString();
    }

}