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
            Binary search
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
    public static List<Double> bubbleSort(List<Double> arr) {
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

        return arr;
    }

    /*******************************************
                    Quick sort
     ******************************************/
    public static List<Double> quickSort(List<Double> arr, int low, int high) {
        //Set the initial high and low values
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

        return arr;
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
    public static List<Double> insertionSort(List<Double> arr) {
        for(int i = 1; i < arr.size(); ++i) {
            double prevElem = arr.get(i);
            int j;
            for(j = i - 1; j >= 0 && arr.get(j) > prevElem; --j) {
                arr.set(j + 1, arr.get(j));
            }
            arr.set(j + 1, prevElem);
        }
        return arr;
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

    public static List<Double> mergeSort(List<Double> arr, int low, int high) {
        if (low >= high) { return null; }
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
        return arr;
    }


    /*******************************************
                    Heap sort
     ******************************************/
    public static List<Double> heapSort(List<Double> arr) {
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
        return arr;
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
    public static List<Double> radixSort(List<Double> doubleList) {
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

        return doubleList;
    }

    /*******************************************
                    Shell sort
     ******************************************/
    public static List<Double> shellSort(List<Double> list) {
        int n = list.size();

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                double temp = list.get(i);
                int j = i;

                // Shift earlier gap-sorted elements up until the correct location is found
                while (j >= gap && list.get(j - gap) > temp) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }

                // Put temp in its correct location
                list.set(j, temp);
            }
        }
        return list;
    }

    /*******************************************
                    Bucket sort
     ******************************************/
    public static List<Double> bucketSort(List<Double> list) {
        if (list.isEmpty()) return null;

        int n = list.size();
        List<List<Double>> buckets = new ArrayList<>(n);

        // Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Find min and max to scale values into buckets
        double min = Collections.min(list);
        double max = Collections.max(list);
        double range = max - min;

        // Distribute elements into buckets
        for (double value : list) {
            int index = (int) ((value - min) / range * (n - 1));
            buckets.get(index).add(value);
        }

        // Sort each bucket and concatenate results
        list.clear();
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket); // You can use insertion sort here for small buckets
            list.addAll(bucket);
        }

        return list;
    }

}