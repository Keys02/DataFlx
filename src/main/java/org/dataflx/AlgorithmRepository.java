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

    /*=================================
            Sorting Algorithms
    ===================================*/
}