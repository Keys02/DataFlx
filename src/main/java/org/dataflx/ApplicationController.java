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
                    List<Object> userInputs = this.prepareSearch("Sequential search");
                    int searchedNumIndex = AlgorithmRepository.sequentialSearch((List<Double>) userInputs.getFirst(), (Double) userInputs.getLast());
                    System.out.println("The number can be found at index  " + searchedNumIndex);
                    break;
                }
            case 2: {
                    List<Object> userInputs = this.prepareSearch("Binary search");
                    int searchedNumIndex = AlgorithmRepository.binarySearch((List<Double>) userInputs.getFirst(), (Double) userInputs.getLast());
                    System.out.println("The number can be found at index  " + searchedNumIndex);
                    break;
                    }
            default:
                stageController.displayInputError();
                this.processSearch();
        }
    }

    private List<Object> prepareSearch(String notice) {
        System.out.println("Algorithm: " + ANSI.BLUE + ANSI.BOLD + notice + ANSI.RESET);
        List<Double> sortDataSet = stageController.inputDataSet(new Scanner(System.in));
        System.out.println("Algorithm: " + ANSI.BLUE + ANSI.BOLD + notice + ANSI.RESET);
        double searchNum = stageController.searchNumber(new Scanner(System.in));
        List<Object> inputs = new ArrayList<>();
        inputs.add(sortDataSet);
        inputs.add(searchNum);
        return inputs;
    }

    // Sorting operations controller
    private void processSort() {
        int sortAlgoOption = stageController.sortOperation(new Scanner(System.in));

//        ArrayList<Double> sortDataSet = stageController.inputDataSet(new Scanner(System.in));
        switch (sortAlgoOption) {
            case 0:
                this.flushApp();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                stageController.displayInputError();
                stageController.sortOperation(new Scanner(System.in));
        }
    }
}
