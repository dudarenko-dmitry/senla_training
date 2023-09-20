package pl.senla.task9.ex2;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        new Thread(new MyClass(new Semaphore(1))).start();
        new Thread(new MyClass(new Semaphore(1))).start();

    }
}
