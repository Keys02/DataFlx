package org.dataflx;
import java.util.Scanner;

public class Application {
    private ApplicationController appCtrl;

    public Application() {
        this.appCtrl = new ApplicationController();
    }

    public void run () {
        appCtrl.flushApp();
    }
}
