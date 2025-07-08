package org.dataflx;

public class Application {
    private ApplicationController appController;

    public Application() {
        this.appController = new ApplicationController();
    }

    public void run () {
        appController.flushApp();
    }
}
