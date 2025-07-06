package org.dataflx;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StageController
{
    public int actionOperation(Scanner scanner) {
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");

        System.out.print("input> ");
        int operation = scanner.nextInt();
        System.out.print("\n");
        return operation;
    }

    public int searchOperation(Scanner scanner) {
        System.out.println("Operation: " + ANSI.BLUE + ANSI.BOLD + "Sorting" + ANSI.RESET);
        System.out.println("1) Sequential search");
        System.out.println("2) Binary search");
        System.out.println("0) Back");

        // Enter choice
        System.out.print("input> ");
        int searchAlgoOption = scanner.nextInt();
        System.out.print("\n");
        return searchAlgoOption;
    }

    public int sortOperation(Scanner scanner) {
        System.out.println("Operation: " + ANSI.BLUE + ANSI.BOLD + "Sorting" + ANSI.RESET);
        System.out.println("1) Bubble sort");
        System.out.println("2) Heap sort");
        System.out.println("3) Insertion sort");
        System.out.println("4) Merge sort");
        System.out.println("5) Quick sort");
        System.out.println("6) Radix sort");
        System.out.println("7) Shell sort");
        System.out.println("0) Back");

        // Enter choice
        System.out.print("input> ");
        int sortAlgoOption = scanner.nextInt();
        System.out.print("\n");
        return sortAlgoOption;
    }

    public ArrayList<Double> inputDataSet(Scanner scanner, String notice) {
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter all numbers separated with comma or whitespace" + ANSI.RESET);
        System.out.print("input> ");
        String numbersInput = scanner.nextLine();
        System.out.print("\n");

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
        return nums;
    }

    public List<Object> prepareFinalSearchOperation(String notice) {
        List<Double> sortDataSet = this.inputDataSet(new Scanner(System.in), notice);
        double searchNum = this.searchNumber(new Scanner(System.in), notice);

        List<Object> inputs = new ArrayList<>();
        inputs.add(sortDataSet);
        inputs.add(searchNum);
        return inputs;
    }

    public double searchNumber(Scanner scanner, String notice) {
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter the number you want to search" + ANSI.RESET);
        System.out.print("input> ");
        double searchNum = scanner.nextDouble();
        System.out.print("\n");
        return searchNum;
    }

    public void displayInputError() {
        System.out.println(ANSI.RED + "⚠️: Incorrect choice, try again" + ANSI.RESET);
    }


}
