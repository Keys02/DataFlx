package org.dataflx;
import java.util.Scanner;

public class Application {
    private MasterController masterCtrl;

    public Application() {
        this.masterCtrl= new MasterController();
    }

    public void run () {
        masterCtrl.flushApp();
    }
}
