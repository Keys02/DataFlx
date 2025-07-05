package org.dataflx;
import java.util.Scanner;
import java.util.List;

public class ApplicationController
{
    private AlgorithmRepository algorithmRepository;

    public ApplicationController() {
        this.algorithmRepository = new AlgorithmRepository();
    }

    Scanner scanner = new Scanner(System.in);
    // Searching operations controller
    public void processSearch() {
        System.out.println("Algorithm");
        System.out.println("1) Linear search");
        System.out.println("2) Binary search");

        int searchAlgoOption = scanner.nextInt();

        if (searchAlgoOption == 1) {

        } else if(searchAlgoOption == 2) {

        } else {
            this.processSearch();
        }
    }
    // Sorting operations controller
    public void processSort() {
        System.out.println("Algorithm");
        System.out.println("1) Bubble sort");
        System.out.println("2) Heap sort");
        System.out.println("3) Insertion sort");
        System.out.println("4) Merge sort");
        System.out.println("5) Quick sort");
        System.out.println("6) Radix sort");
        System.out.println("7) Shell sort");

        int sortAlgoOption = scanner.nextInt();

        if (sortAlgoOption == 1) {

        } else if (sortAlgoOption == 2) {

        } else if (sortAlgoOption == 3) {

        } else if (sortAlgoOption == 4) {

        } else if (sortAlgoOption == 5) {

        } else if (sortAlgoOption == 6) {

        } else if (sortAlgoOption == 7) {

        } else {
            this.displayInputError();
            this.processSort();
        }
    }

    public void displayInputError() {
        System.out.println("⚠️: Incorrect choice, try again");
    }
}
