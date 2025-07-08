package org.dataflx;

public class DataFlx
{
    public static void main(String[] args) {
        Application app = new Application();
        try {
            app.run();
        } catch (Exception e) {
            System.out.println(ANSI.RED + "[FATAL_0x001A] 💀 An unrecoverable error has occurred and the application must close." + ANSI.RESET);
        }
    }
}