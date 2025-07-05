package org.dataflx;

import java.util.Scanner;

public class MasterController
{
    private ApplicationController appCtrl;

    public MasterController() {
        this.appCtrl = new ApplicationController();
    }

    public void flushApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Operation");
        System.out.println("1) Searching");
        System.out.println("2) Sorting");
        System.out.print("input> ");
        int operation = scanner.nextInt();

        System.out.println(ANSI.BLUE + operation + ANSI.RESET);

        if (operation == 1) {
            appCtrl.processSearch();
        } else if(operation == 2) {
            appCtrl.processSort();
        } else {
            appCtrl.displayInputError();
            this.flushApp();
        }
    }
}
