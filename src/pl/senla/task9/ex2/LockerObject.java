package pl.senla.task9.ex2;

public class LockerObject {

    private static LockerObject lockerObject;

    private LockerObject() {
    }

    public static LockerObject getLockerObject() {
        if (lockerObject == null) {
            lockerObject = new LockerObject();
        }
        return lockerObject;
    }

    private static int counter = 1;

    public synchronized void startFirst(int i) {
        if (counter == 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread First is interrupted.");
                throw new RuntimeException(e);
            }
        }
        System.out.println("First: " + i);
        counter = 2;
        notify();
    }

    public synchronized void startSecond(int i) {
        if (counter == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread Second is interrupted.");
                throw new RuntimeException(e);
            }
        }
        System.out.println("Second: " + i);
        counter = 1;
        notify();
    }

}
