package org.dataflx;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ApplicationController extends StageController
{
    private AlgorithmRepository algorithmRepository;
    private Scanner scanner;

    // Constructor
    public ApplicationController() {
        this.algorithmRepository = new AlgorithmRepository();
        this.scanner = new Scanner(System.in);
    }

    public void flushApp() {
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");

        System.out.print("input> ");
        int operation = scanner.nextInt();
        System.out.print("\n");

        if (operation == 1) {
            this.processSearch();
            ArrayList<Double> dataSet = inputDataSet(new Scanner(System.in));
        } else if(operation == 2) {
            this.processSort();
            ArrayList<Double> dataSet = inputDataSet(new Scanner(System.in));
        } else {
            this.displayInputError();
            this.flushApp();
        }
        this.scanner.close();
    }

    public ArrayList<Double> inputDataSet(Scanner dataSetInputs) {
        System.out.println("Enter all numbers separated with comma or whitespace");
        System.out.print("input> ");
        String numbersInput = dataSetInputs.nextLine();

        String[] numbersToArr = numbersInput.split("[,\\s+(, )]+"); // Splitting with multiple delimiters

        ArrayList<Double> nums = new ArrayList<Double>(numbersToArr.length);

        for (String s : numbersToArr) {
            try {
                nums.add(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                System.out.println("Warning: Enter only integers or decimals\n");
                System.exit(0);
            }
        }

        dataSetInputs.close();
        return nums;
    }

    // Searching operations controller
    public void processSearch() {
        System.out.println("Operation: " + ANSI.BOLD + "Sorting" + ANSI.RESET);
        System.out.println("1) Linear search");
        System.out.println("2) Binary search");
        System.out.println("0) Back");

        // Enter choice
        System.out.print("input> ");
        int searchAlgoOption = scanner.nextInt();
        System.out.print("\n");

        if (searchAlgoOption == 0) {
            // Return to previous choices
            this.flushApp();
        } else if (searchAlgoOption == 1) {

        } else if (searchAlgoOption == 2) {

        } else {
            this.processSearch();
        }
    }
    // Sorting operations controller
    public void processSort() {

        int sortAlgoOption = this.operationStage();

        if (sortAlgoOption == 0) {
            // Return to previous choices
            this.flushApp();
        } else if (sortAlgoOption == 1) {

        } else if (sortAlgoOption == 2) {

        } else if (sortAlgoOption == 3) {

        } else if (sortAlgoOption == 4) {

        } else if (sortAlgoOption == 5) {

        } else if (sortAlgoOption == 6) {

        } else if (sortAlgoOption == 7) {

        } else {
            this.displayInputError();
            this.operationStage();
        }
    }

    public void displayInputError() {
        System.out.println(ANSI.RED + "⚠️: Incorrect choice, try again" + ANSI.RESET);
    }

}
