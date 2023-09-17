package pl.senla.task9.ex2;

import static java.lang.Thread.*;

public class Second implements Runnable{

    private final LockerObject lockerObject = LockerObject.getLockerObject();

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lockerObject.startSecond(i);
        }
    }

}
