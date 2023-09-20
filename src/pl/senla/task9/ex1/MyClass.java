package pl.senla.task9.ex1;

import static java.lang.Thread.*;

public class MyClass implements Runnable{

    private final Locker locker = Locker.getLocker();
    private static final Object block = new Object();

    private boolean isSleep;
    private boolean isWait;

    public static Object getBlock() {
        return block;
    }

    @Override
    public void run() {
        try {
            synchronized (block) {
                sleep(1000);
                block.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!interrupted()) {
            if (isSleep) {
                try {
                    sleep(3000);
                    isSleep = false;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (isWait == true) {
                locker.waitThread(isWait);
            }

            if (isWait == false) {
                locker.waitThread(isWait);
            }
        }
    }

    public void sleepThread() {
        isSleep = true;
    }

    public void waitThread() {
        isWait = true;
    }

    public void notifyThread() {
        isWait = false;
    }

}
