package org.dataflx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

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
        System.out.println("Operation: " + ANSI.BLUE + ANSI.BOLD + "Searching" + ANSI.RESET);
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
        System.out.println("2) Quick sort");
        System.out.println("3) Insertion sort");
        System.out.println("4) Merge sort");
        System.out.println("5) Heap sort");
        System.out.println("6) Radix sort");
        System.out.println("7) Shell sort");
        System.out.println("8) Bucket sort");
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

        // Enter dataset
        String numbersInput = scanner.nextLine();
        System.out.print("\n");

        String[] numbersToArr = numbersInput.split("[,\\s+(, )]+"); // Splitting with multiple delimiters

        ArrayList<Double> nums = new ArrayList<Double>(numbersToArr.length);

        for (String s : numbersToArr) {
                nums.add(Double.parseDouble(s));
        }
        return nums;
    }


    public double searchNumber(Scanner scanner, String notice) {
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter the number you want to search" + ANSI.RESET);
        System.out.print("input> ");

        // Enter number to be searched
        double searchNum = scanner.nextDouble();
        System.out.print("\n");
        return searchNum;
    }

    public void displayInputError() {
        System.out.println(ANSI.RED + "⚠️: Incorrect choice, try again" + ANSI.RESET);
        System.out.print("\n");
    }

    public void searchNumInputError() {
        System.out.println(ANSI.RED + "⚠️: Incorrect input: Enter an integer or decimal, try again" + ANSI.RESET);
        System.out.print("\n");
    }

    public void incorrectDataSetInputError() {
        System.out.println(ANSI.RED + "⚠️: Incorrect input: Enter a dataset containing only integer and decimal, try again" + ANSI.RESET);
        System.out.print("\n");
    }

    public void searchOperationResult(int searchedNumIndex, String notice, String runtimeInBigONotation) {
        System.out.println("Algorithm: " + ANSI.BLUE  + ANSI.BOLD + notice + ANSI.RESET);
        System.out.println("The number can be found at index " + ANSI.BOLD + ANSI.PURPLE + searchedNumIndex + ANSI.RESET);
        System.out.println("Runtime in Big O Notation: " + ANSI.BOLD + ANSI.YELLOW + runtimeInBigONotation + ANSI.RESET + " in the worst case scenario.");
    }

    public void sortOperationResult(String arr, String notice, String runtimeInBigONotation) {
        System.out.println("Algorithm: " + ANSI.BLUE  + ANSI.BOLD + notice + ANSI.RESET);
        System.out.println("Sorted Array: " + ANSI.PURPLE + arr + ANSI.RESET);
        System.out.println("Runtime in Big O Notation: " + ANSI.BOLD + ANSI.YELLOW + runtimeInBigONotation + ANSI.RESET + " in the worst case scenario.");
    }

}
