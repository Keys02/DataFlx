package org.dataflx;
import java.util.List;

public class AlgorithmRepository
{
    /*=================================
            Searching Algorithms
    ===================================*/
    public static int sequentialSearch(List<Double> arr, double key) {
        int arrayLength = arr.size();
        arr.add(key);
        int i = 0;

        while ((double) arr.get(i) != key) { i++; }

        arr.removeLast();

        return (i == arrayLength) ? -1 : i;
    }

    public static int binarySearch(List<Double> arr, double key) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*=================================
            Sorting Algorithms
    ===================================*/
}