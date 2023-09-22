package pl.senla.task9.ex2;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1, true);
        new Thread(new MyClass(semaphore)).start();
        new Thread(new MyClass(semaphore)).start();

    }
}
