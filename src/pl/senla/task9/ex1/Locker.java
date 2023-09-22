package pl.senla.task9.ex1;

public class Locker {

    private static Locker locker;

    private Locker() {
    }

    public static Locker getLocker() {
        if (locker == null) {
            locker = new Locker();
        }
        return locker;
    }

    public synchronized void waitThread(boolean isWait) {
        if (isWait) {
            try {
                System.out.println("Locker make myThread's state WAIT.");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted...");
            }
        }
        notify();
    }
}
