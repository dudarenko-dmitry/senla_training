package pl.senla.task9.ex2;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class MyClass implements Runnable{

    Semaphore semaphore;

    public MyClass(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            try {
                semaphore.acquire();
                System.out.println(name);
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphore.release();
        }
    }

}
