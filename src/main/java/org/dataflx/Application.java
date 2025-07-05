package org.dataflx;
import java.util.Scanner;

public class Application {
    private ApplicationController appCont;

    public Application() {
        this.appCont = new ApplicationController();
    }

    public void run () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");
        int operation = scanner.nextInt();

        if (operation == 1) {
            appCont.processSearch();
        } else if(operation == 2) {
            appCont.processSort();
        } else {
            appCont.displayInputError();
            this.run();
        }

    }
}
