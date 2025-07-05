package org.dataflx;
import java.util.Scanner;

public class StageController
{
    public int operationStage() {
        Scanner operationController = new Scanner(System.in);

        System.out.println("Operation: " + ANSI.BOLD + "Sorting" + ANSI.RESET);
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
        int sortAlgoOption = operationController.nextInt();
        System.out.print("\n");
        return sortAlgoOption;
    }
}
