package pl.senla.task9.ex1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyClass myClass = new MyClass();
        Object block = MyClass.getBlock();
        Locker locker = Locker.getLocker();

        System.out.println("Start application.");
        Thread myThread = createThread(myClass);
        startThread(myThread);
        blockThread(myThread, block);
        sleepThread(myThread, myClass);
        waitThread(myThread, myClass, locker, block);
        interruptThread(myThread);
        System.out.println("Application complete.");
    }

    private static Thread createThread(MyClass myClass) {
        System.out.println("\nCreate new thread:");
        Thread newThread = new Thread(myClass);
        System.out.println("State must be NEW: " + newThread.getState());
        return newThread;
    }

    private static void startThread(Thread myThread) {
        System.out.println("\nStart new thread:");
        myThread.start();
        System.out.println("State must be RUNNABLE: " + myThread.getState());
    }

    private static void blockThread(Thread myThread, Object block) throws InterruptedException {
        System.out.println("\nBlock thread:");
        sleep(100);
        synchronized (block){
            block.notify();
            for (int blockCounter = 1; blockCounter < 4; blockCounter++) {
                System.out.println("State must be BLOCKED " + blockCounter + ": " + myThread.getState() + " "
                        + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                sleep(1000);
            }
        }
        sleep(1000);
        System.out.println("State must be RUNNABLE again: " + myThread.getState());
    }

    private static void sleepThread(Thread myThread, MyClass myClass) throws InterruptedException {
        System.out.println("\nSleep thread for 3 sec:");
        myClass.sleepThread();
        sleep(100);
        for (int sleepCounter = 1; sleepCounter < 4; sleepCounter++) {
            System.out.println("State must be Timed-Waiting " + sleepCounter + ": " + myThread.getState() + " "
                    + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            sleep(1000);
        }
        System.out.println("Wake up Thread!");
        System.out.println("State must be RUNNABLE: " + myThread.getState());
    }

    private static void waitThread(Thread myThread, MyClass myClass, Locker locker, Object block) throws InterruptedException {
        myClass.notifyThread();
        System.out.println("\nWait thread for 3 sec:");
        myClass.waitThread();
        sleep(100);
        for (int waitCounter = 1; waitCounter < 4; waitCounter++) {
            System.out.println("State must be WAITING " + waitCounter + ": " + myThread.getState() + " "
                    + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            sleep(1000);
        }
        System.out.println("Notify Thread!");
        myClass.notifyThread();
        locker.waitThread(false);
        sleep(1000);
        System.out.println("State must be RUNNABLE: " + myThread.getState());
    }

    private static void interruptThread(Thread myThread) throws InterruptedException {
        System.out.println("\nInterrupt thread:");
        myThread.interrupt();
        myThread.join();
        System.out.println("State must be TERMINATED: " + myThread.getState());
    }

}
