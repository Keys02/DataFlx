package org.dataflx;
import java.util.Scanner;

public class Application {
    public void run () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");
        int operation = scanner.nextInt();

        ApplicationController appCont = new ApplicationController();

        if (operation == 1) {
            appCont.performSearch();
        } else {
            appCont.performSort();
        }

    }
}
