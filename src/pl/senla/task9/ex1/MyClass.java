package pl.senla.task9.ex1;

import static java.lang.Thread.*;

public class MyClass implements Runnable{

    private final Locker locker = Locker.getLocker();
    private static final Object block = new Object();

//    private boolean isBlocked = true;
    private boolean isSleep = false;
    private boolean isWait = false;

    public static Object getBlock() {
        return block;
    }

    @Override
    public void run() {
        try {
            synchronized (block) {
                block.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!interrupted()) {
            if (isSleep) {
                synchronized (block) {
                    try {
                        sleep(3000);
                        isSleep = false;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (isWait) {
                locker.waitThread(true);
            }
        }
    }

    public void sleepThread() {
        isSleep = true;
    }

    public void waitThread() {
        isWait = true;
    }

    public void wakeUpThread() {
        isWait = false;
    }

}
