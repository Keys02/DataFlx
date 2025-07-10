package org.dataflx;
import java.util.*;

public class ApplicationController
{
    private StageController stageController;

    // Constructor
    public ApplicationController() {
        this.stageController = new StageController();
    }

    public void flushApp() {
        try {
            // Catch InputMismatchException ie when a user does not enter a number (Integer)
            int operation = stageController.actionOperation(new Scanner(System.in));

            switch (operation) {
                case 1:
                    this.processSearch();
                    break;
                case 2:
                    this.processSort();
                    break;
                default:
                    StageController.displayInputError();
                    this.flushApp();
            }
        } catch(InputMismatchException e) {
            StageController.displayInputError();
            flushApp();
        }
    }

    // Searching operations controller
    private void processSearch() {
        try {
            // Catch InputMismatchException ie when a user does not enter a number (Integer)
            int searchAlgoOption = stageController.searchOperation(new Scanner(System.in));

            switch (searchAlgoOption) {
                case 0:
                    this.flushApp();
                    break;
                case 1: {
                    // Sequential search
                        try {
                            List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Sequential search");
                            double searchedNum = stageController.searchNumber(new Scanner(System.in), "Sequential search");
                            int searchedNumIndex = AlgorithmRepository.sequentialSearch(userDataSet, searchedNum);
                            stageController.searchOperationResult(searchedNumIndex, "Sequential search", "O(n)");
                        } catch (InputMismatchException | NumberFormatException e) {
                            // Handle users not entering a number as an element of a dataset or a search number exception
                            if (e instanceof NumberFormatException) {
                                StageController.incorrectDataSetInputError();
                            } else {
                                StageController.searchNumInputError();
                            }
                            this.processSearch();
                        }
                        break;
                }

                case 2: {
                    // Binary search
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Binary search");
                        double searchedNum = stageController.searchNumber(new Scanner(System.in), "Binary search");
                        int searchedNumIndex = AlgorithmRepository.binarySearch(userDataSet, searchedNum);
                        stageController.searchOperationResult(searchedNumIndex, "Binary search", "O(log n)");
                    } catch (InputMismatchException | NumberFormatException e) {
                        // Handle users not entering a number as an element of a dataset or a search number exception
                        if (e instanceof NumberFormatException) {
                            StageController.incorrectDataSetInputError();
                        } else {
                            StageController.searchNumInputError();
                        }
                        this.processSearch();
                    }
                    break;
                }

                default:
                    StageController.displayInputError();
                    this.processSearch();
            }
        } catch(InputMismatchException | NumberFormatException e) {
            StageController.displayInputError();
            this.processSearch();
        }
    }


    // Sorting operations controller
    private void processSort() {
        try {
            // Catch InputMismatchException ie when a user does not enter a number (Integer)
            int sortAlgoOption = stageController.sortOperation(new Scanner(System.in));

            switch (sortAlgoOption) {
                case 0:
                    // Back
                    this.flushApp();
                    break;
                case 1: {
                    // Bubble sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Bubble sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.bubbleSort(userDataSet));
                        stageController.sortOperationResult(sortedArray, "Bubble sort", "O(n²)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 2: {
                    // Quick sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Quick sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.quickSort(userDataSet, 0, userDataSet.size() - 1));
                        stageController.sortOperationResult(sortedArray, "Quick sort", "0(n²)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 3: {
                    // Insertion sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Insertion sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.insertionSort(userDataSet));
                        stageController.sortOperationResult(sortedArray, "Insertion sort", "0(n²)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                break;
                }
                case 4: {
                    // Merge sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Merge sort");
                        String sortedArray = StageController.makeSortedListReadable(Objects.requireNonNull(AlgorithmRepository.mergeSort(userDataSet, 0, userDataSet.size() - 1)));
                        stageController.sortOperationResult(sortedArray, "Merge sort", "O(n log n)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 5: {
                    // Heap sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Heap sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.heapSort(userDataSet));
                        stageController.sortOperationResult(sortedArray, "Heap sort", "O(n log n)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 6: {
                    // Radix sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Radix sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.radixSort(userDataSet));
                        stageController.sortOperationResult(sortedArray, "Radix sort", "O(nk)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 7: {
                    // Shell sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Shell sort");
                        String sortedArray = StageController.makeSortedListReadable(AlgorithmRepository.shellSort(userDataSet));
                        stageController.sortOperationResult(sortedArray, "Shell sort", "0(n²)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                case 8: {
                    // Bucket sort
                    try {
                        List<Double> userDataSet = stageController.inputDataSet(new Scanner(System.in), "Bucket sort");
                        String sortedArray = StageController.makeSortedListReadable(Objects.requireNonNull(AlgorithmRepository.bucketSort(userDataSet)));
                        stageController.sortOperationResult(sortedArray, "Bucket sort", "O(n²)");
                    } catch (NumberFormatException e) {
                        // Handle exception when a member of the dataset cannot be parsed as a Double
                        StageController.incorrectDataSetInputError();
                        this.processSort();
                    }
                    break;
                }
                default:
                    StageController.displayInputError();
                    stageController.sortOperation(new Scanner(System.in));
            }
        } catch(InputMismatchException e) {
            StageController.displayInputError();
            this.processSort();
        }
    }
}
