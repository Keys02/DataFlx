package org.dataflx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class StageController
{
    public int actionOperation(Scanner scanner) throws UnrecognizedChoiceException {
        System.out.print("\n");
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");

        // Choice entry
        System.out.print("input> ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice < 3) {
            return choice;
        } else {
            throw new UnrecognizedChoiceException("Unrecognized choice");
        }
    }

    public int searchOperation(Scanner scanner) throws UnrecognizedChoiceException {
        System.out.print("\n");
        System.out.println("Operation: " + ANSI.BLUE + ANSI.BOLD + "Searching" + ANSI.RESET);
        System.out.println("1) Sequential search");
        System.out.println("2) Binary search");
        System.out.println("0) Back");

        // Choice entry
        System.out.print("input> ");
        int choice = scanner.nextInt();

        if (choice >= 0 && choice <= 2) {
            return choice;
        } else {
            throw new UnrecognizedChoiceException("Unrecognized choice");
        }
    }

    public int sortOperation(Scanner scanner) throws UnrecognizedChoiceException {
        System.out.print("\n");
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

        // Choice entry
        System.out.print("input> ");

        int choice = scanner.nextInt();

        if (choice >= 0 && choice <= 8) {
            return choice;
        } else {
            throw new UnrecognizedChoiceException("Unrecognized choice");
        }
    }

    public int dataSetInputMethod(Scanner scanner, String notice) throws UnrecognizedChoiceException {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "How would like to input your dataset?" + ANSI.RESET);
        System.out.println("1) Input the dataset");
        System.out.println("2) Upload file containing dataset");
        System.out.println("0) Back");

        // Choice entry
        System.out.print("input> ");
        int choice = scanner.nextInt();

        if (choice >= 0 && choice <= 2) {
            return choice;
        } else {
            throw new UnrecognizedChoiceException("Unrecognized choice");
        }
    }

    public ArrayList<Double> readFromFile(Scanner filePath, String notice) {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter the path of the file" + ANSI.RESET);
        System.out.print("input> ");
        String file = filePath.nextLine();

        // Create an instance of a BufferedReader
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String numbersInput = fileReader.readLine();
            System.out.println("Dataset read from file: " + ANSI.PURPLE + "[" + numbersInput + "]" + ANSI.RESET);

            return this.buildDataSet(filePath, numbersInput);
        } catch (IOException e) {
            this.fileDoesNotExistError();
            System.exit(0);
        }
        return null;
    }

    public ArrayList<Double> inputDataSet(Scanner scanner, String notice) {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter all numbers, using commas or whitespace as separators." + ANSI.RESET);
        System.out.print("input> ");

        // Enter dataset
        String numbersInput = scanner.nextLine();

        return this.buildDataSet(scanner, numbersInput);
    }

    private ArrayList<Double> buildDataSet(Scanner scanner, String numbersInput) {
        // Enter dataset
        String[] numbersToArr = numbersInput.split("[,\\s+(, )]+"); // Splitting with multiple delimiters

        ArrayList<Double> nums = new ArrayList<Double>(numbersToArr.length);

        for (String s : numbersToArr) {
            nums.add(Double.parseDouble(s));
        }
        return nums;
    }

    public double searchNumber(Scanner scanner, String notice) {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BOLD + ANSI.BLUE + notice + ANSI.RESET);
        System.out.println(ANSI.ORANGE + "Enter the number to be searched" + ANSI.RESET);

        // Choice entry
        System.out.print("input> ");
        return scanner.nextDouble();
    }


    public void searchOperationResult(int searchedNumIndex, String notice, String runtimeInBigONotation) {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BLUE  + ANSI.BOLD + notice + ANSI.RESET);
        System.out.println("The number can be found at index " + ANSI.BOLD + ANSI.PURPLE + searchedNumIndex + ANSI.RESET);
        System.out.println("Runtime in Big O Notation: " + ANSI.BOLD + ANSI.YELLOW + runtimeInBigONotation + ANSI.RESET + " in the worst case scenario.");
    }

    public void sortOperationResult(String arr, String notice, String runtimeInBigONotation) {
        System.out.print("\n");
        System.out.println("Algorithm: " + ANSI.BLUE  + ANSI.BOLD + notice + ANSI.RESET);
        System.out.println("Sorted Array: " + ANSI.PURPLE + arr + ANSI.RESET);
        System.out.println("Runtime in Big O Notation: " + ANSI.BOLD + ANSI.YELLOW + runtimeInBigONotation + ANSI.RESET + " in the worst case scenario.");
    }

    public String makeSortedListReadable(List<Double> arr) {
        // An empty to store all instances of numbers ie Integer, Double, Float etc
        List<Number> IntegerList = new ArrayList<>();

        // Parse the numbers as Double type
        for (Double aDouble : arr) {
            if (aDouble % 1 == 0) {
                IntegerList.add(aDouble.intValue());
            } else {
                IntegerList.add(aDouble);
            }
        }
        return IntegerList.toString();
    }

    public String reflashApp(Scanner scanner) {
        System.out.print("\n");
        System.out.println(ANSI.GREEN + "✅: Would you like to keep going?" + ANSI.RESET);

        // Choice entry
        System.out.println(ANSI.YELLOW + "[Y] Yes  " + ANSI.RESET + "  [N] No");
        System.out.print("input> ");
        return scanner.nextLine();
    }

    public void exitWithFarewell() {
        System.out.print("\n");
        System.out.print("🙋🏽‍♂️: Goodbye!!!");
        System.exit(0);
    }

    /*********************************
            Error display section
    *********************************/
    public void unrecognizedChoiceError() {
        System.out.println(ANSI.RED + "⚠️: Your choice was not recognized. Please try again." + ANSI.RESET);
    }

    public void invalidInputError() {
        System.out.println(ANSI.RED + "⚠️: Your input was invalid. Please enter a number" + ANSI.RESET);
    }

    public void incorrectDataSetInputError() {
        System.out.println(ANSI.RED + "⚠️: The dataset you entered contains invalid characters. Please ensure your dataset contains only integers and decimals." + ANSI.RESET);
    }

    public void fileDoesNotExistError() {
        System.out.println(ANSI.RED + "⚠️: The file you are trying to read from does not exist" + ANSI.RESET);
    }

}
