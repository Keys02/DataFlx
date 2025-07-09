package org.dataflx;

public class Application {
    private ApplicationController appController;

    private static Application instance;

    private Application() {
        this.appController = new ApplicationController();
    }

    public static Application getInstance() {
        // Apply Singleton Design Pattern
        if (Application.instance == null) {
            Application.instance = new Application();
        }
        return Application.instance;
    }


    public void run () {
        appController.flushApp();
    }
}
