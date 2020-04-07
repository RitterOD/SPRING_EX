package org.maslov.simpleDAL;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hello DAL !");
        TestDAL tDAL = new TestDAL();
        tDAL.perform();
    }
}
