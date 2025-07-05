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
    public void performSearch(List<Double> arr, double number) {
        System.out.println("Algorithm");
        System.out.println("1) Linear search");
        System.out.println("2) Binary search");

        int searchAlgoOption = scanner.nextInt();

        if (searchAlgoOption == 1) {

        } else {

        }
    }
    // Sorting operations controller
    public void performSort(List<Double> arr, double number) {
        System.out.println("Algorithm");
        System.out.println("1) Linear search");
        System.out.println("2) Binary search");

        int sortAlgoOption = scanner.nextInt();

        if (sortAlgoOption == 1) {

        } else {

        }
    }
}
