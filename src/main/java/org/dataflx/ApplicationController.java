package org.dataflx;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ApplicationController extends StageController
{
    private AlgorithmRepository algorithmRepository;

    // Constructor
    public ApplicationController() {
        this.algorithmRepository = new AlgorithmRepository();
    }

    public void flushApp() {
        int operation = this.operationStageController(new Scanner(System.in));
        switch (operation) {
            case 1:
                ArrayList<Double> searchDataSet = this.inputDataSet(new Scanner(System.in));
                this.processSearch(searchDataSet, 4);
                break;
            case 2:
                this.processSort();
                ArrayList<Double> sortDataSet = this.inputDataSet(new Scanner(System.in));
                break;
            default:
                this.displayInputError();
                this.flushApp();
        }
    }

    // Searching operations controller
    public void processSearch(List<Double> arr, double key) {
        int searchAlgoOption = this.searchOperationStage(new Scanner(System.in));
        switch (searchAlgoOption) {
            case 0:
                this.flushApp();
                break;
            case 1:
                AlgorithmRepository.sequentialSearch(arr, key);
                break;
            case 2:
                break;
            default:
                this.searchOperationStage(new Scanner(System.in));
        }
    }
    // Sorting operations controller
    public void processSort() {

        int sortAlgoOption = this.sortOperationStage(new Scanner(System.in));

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
                this.displayInputError();
                this.sortOperationStage(new Scanner(System.in));
        }
    }
}
