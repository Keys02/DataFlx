package org.dataflx;
import java.io.FileNotFoundException;
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
                    stageController.unrecognizedChoiceError();
                    this.flushApp();
            }
        } catch(UnrecognizedChoiceException | InputMismatchException e) {
            if (e instanceof UnrecognizedChoiceException) {
                stageController.unrecognizedChoiceError();
            } else {
                stageController.invalidInputError();
            }
            this.flushApp();
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
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Sequential search", "Searching");
                    double searchedNum = stageController.searchNumber(new Scanner(System.in), "Sequential search");
                    int searchedNumIndex = AlgorithmRepository.sequentialSearch(userDataSet, searchedNum);
                    stageController.searchOperationResult(searchedNumIndex, "Sequential search", "O(n)");
                    break;
                }

                case 2: {
                    // Binary search
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Sequential search", "Searching");
                    double searchedNum = stageController.searchNumber(new Scanner(System.in), "Binary search");
                    int searchedNumIndex = AlgorithmRepository.binarySearch(userDataSet, searchedNum);
                    stageController.searchOperationResult(searchedNumIndex, "Binary search", "O(log n)");
                    break;
                }

                default:
                    stageController.unrecognizedChoiceError();
                    this.processSearch();
            }
        } catch(UnrecognizedChoiceException | InputMismatchException | NumberFormatException e) {
            if (e instanceof UnrecognizedChoiceException) {
                stageController.unrecognizedChoiceError();
            } else if (e instanceof NumberFormatException) {
                stageController.incorrectDataSetInputError();
            } else {
                stageController.invalidInputError();
            }
            this.processSearch();
        }

        String reflashAppResponse = stageController.reflashApp(new Scanner(System.in)).toLowerCase();
        // Initialize HashSet with elements directly
        Set<String> reflashAppResponseOptions = new HashSet<>(Arrays.asList("y", "yes", "n", "no"));
        this.checkReflashAppResponse(reflashAppResponse);

        while (!reflashAppResponseOptions.contains(reflashAppResponse)) {
            stageController.unrecognizedChoiceError();
            reflashAppResponse = stageController.reflashApp(new Scanner(System.in));
            this.checkReflashAppResponse(reflashAppResponse);
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
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Bubble sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.bubbleSort(userDataSet));
                    stageController.sortOperationResult(sortedArray, "Bubble sort", "O(n²)");
                    break;
                }

                case 2: {
                    // Quick sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Quick sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.quickSort(userDataSet, 0, userDataSet.size() - 1));
                    stageController.sortOperationResult(sortedArray, "Quick sort", "0(n²)");
                    break;
                }

                case 3: {
                    // Insertion sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Insertion sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.insertionSort(userDataSet));
                    stageController.sortOperationResult(sortedArray, "Insertion sort", "0(n²)");
                    break;
                }

                case 4: {
                    // Merge sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Merge sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(Objects.requireNonNull(AlgorithmRepository.mergeSort(userDataSet, 0, userDataSet.size() - 1)));
                    stageController.sortOperationResult(sortedArray, "Merge sort", "O(n log n)");
                    break;
                }

                case 5: {
                    // Heap sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Heap sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.heapSort(userDataSet));
                    stageController.sortOperationResult(sortedArray, "Heap sort", "O(n log n)");
                    break;
                }

                case 6: {
                    // Radix sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Radix sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.radixSort(userDataSet));
                    stageController.sortOperationResult(sortedArray, "Radix sort", "O(nk)");
                    break;
                }

                case 7: {
                    // Shell sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Shell sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(AlgorithmRepository.shellSort(userDataSet));
                    stageController.sortOperationResult(sortedArray, "Shell sort", "0(n²)");
                    break;
                }

                case 8: {
                    // Bucket sort
                    List<Double> userDataSet = this.processDataSetEntryMethod(new Scanner(System.in), "Bucket sort", "Sorting");
                    String sortedArray = stageController.makeSortedListReadable(Objects.requireNonNull(AlgorithmRepository.bucketSort(userDataSet)));
                    stageController.sortOperationResult(sortedArray, "Bucket sort", "O(n²)");
                    break;
                }

                default:
                    stageController.unrecognizedChoiceError();
                    this.processSort();
            }
        } catch (UnrecognizedChoiceException | InputMismatchException | NumberFormatException e) {
            if (e instanceof NumberFormatException) {
                stageController.incorrectDataSetInputError();
            } else if (e instanceof InputMismatchException) {
                stageController.invalidInputError();
            } else {
                stageController.unrecognizedChoiceError();
            }
            this.processSort();
        }

        String reflashAppResponse = stageController.reflashApp(new Scanner(System.in)).toLowerCase();
        // Initialize HashSet with elements directly
        Set<String> reflashAppResponseOptions = new HashSet<>(Arrays.asList("y", "yes", "n", "no"));
        this.checkReflashAppResponse(reflashAppResponse);

        while (!reflashAppResponseOptions.contains(reflashAppResponse)) {
                stageController.unrecognizedChoiceError();
                reflashAppResponse = stageController.reflashApp(new Scanner(System.in));
                this.checkReflashAppResponse(reflashAppResponse);
        }
    }

    private void checkReflashAppResponse(String reflashAppResponse) {
        if (reflashAppResponse.equalsIgnoreCase("y") || reflashAppResponse.equalsIgnoreCase("yes")) {
            this.flushApp();
        } else if (reflashAppResponse.equalsIgnoreCase("n") || reflashAppResponse.equalsIgnoreCase("no")) {
            stageController.exitWithFarewell();
        }
    }

    private ArrayList<Double> processDataSetEntryMethod(Scanner scanner, String notice, String operation) {
        ArrayList<Double> dataSet = null;
        try {
            int dataSetInputMethod = stageController.dataSetInputMethod(new Scanner(System.in), notice);

            switch (dataSetInputMethod) {
                case 0: {
                    if (operation.equals("Searching")) {
                        this.processSearch();
                    } else {
                        this.processSort();
                    }
                    break;
                }
                case 1: {
                    dataSet = stageController.inputDataSet(scanner, notice);
                    break;
                }
                case 2: {
                    try {
                        dataSet = stageController.readFromFile(scanner, notice);
                    } catch(FileNotFoundException e) {
                        this.flushApp();
                    }
                    break;
                }
                default: {
                    stageController.unrecognizedChoiceError();

                    if (operation.equals("Searching")) {
                        this.processSearch();
                    } else {
                        this.processSort();
                    }
                }
            }
        } catch (UnrecognizedChoiceException e) {
            stageController.unrecognizedChoiceError();

            if (operation.equals("Searching")) {
                this.processSearch();
            } else {
                this.processSort();
            }
        }
        return dataSet;
    }
}
