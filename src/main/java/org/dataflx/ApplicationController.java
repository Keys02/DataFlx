package org.dataflx;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ApplicationController
{
    private StageController stageController;

    // Constructor
    public ApplicationController() {
        this.stageController = new StageController();
    }

    public void flushApp() {
        int operation = stageController.actionOperation(new Scanner(System.in));

        switch (operation) {
            case 1:
                this.processSearch();
                break;
            case 2:
                this.processSort();
                break;
            default:
                stageController.displayInputError();
                this.flushApp();
        }
    }

    // Searching operations controller
    private void processSearch() {
        int searchAlgoOption = stageController.searchOperation(new Scanner(System.in));

        switch (searchAlgoOption) {
            case 0:
                this.flushApp();
                break;
            case 1: {
                        List<Object> userDataSet = stageController.prepareFinalSearchOperation("Sequential search");
                        int searchedNumIndex = AlgorithmRepository.sequentialSearch((List<Double>) userDataSet.getFirst(), (Double) userDataSet.getLast());
                        stageController.searchOperationResult(searchedNumIndex);
                        break;
                    }

            case 2: {
                        List<Object> userDataSet = stageController.prepareFinalSearchOperation("Binary search");
                        int searchedNumIndex = AlgorithmRepository.binarySearch((List<Double>) userDataSet.getFirst(), (Double) userDataSet.getLast());
                        stageController.searchOperationResult(searchedNumIndex);
                        break;
                    }

            default:
                stageController.displayInputError();
                this.processSearch();
        }
    }


    // Sorting operations controller
    private void processSort() {
        int sortAlgoOption = stageController.sortOperation(new Scanner(System.in));

        switch (sortAlgoOption) {
            case 0:
                this.flushApp();
                break;
            case 1: {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Bubble sort");
                        String sortedArray = AlgorithmRepository.bubbleSort(userDataSet);
                        stageController.sortOperationResult(sortedArray, "Bubble sort");
                        break;
                    }
            case 2: {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Quick sort");
                        String sortedArray = AlgorithmRepository.quickSort(userDataSet,0, userDataSet.size() - 1);
                        stageController.sortOperationResult(sortedArray, "Quick sort");
                break;
                    }
            case 3: {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Insertion sort");
                        String sortedArray = AlgorithmRepository.insertionSort(userDataSet);
                        stageController.sortOperationResult(sortedArray, "Insertion sort");
                    }
                break;
            case 4: {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Merge sort");
                        String sortedArray = AlgorithmRepository.mergeSort(userDataSet,0, userDataSet.size() - 1);
                        stageController.sortOperationResult(sortedArray, "Merge sort");
                break;
                    }
            case 5: {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Heap sort");
                        String sortedArray = AlgorithmRepository.heapSort(userDataSet);
                        stageController.sortOperationResult(sortedArray, "Heap sort");
                break;
                    }
            case 6: {

                break;
                    }
            case 7: {

                break;
                    }
            default:
                stageController.displayInputError();
                stageController.sortOperation(new Scanner(System.in));
        }
    }
}
