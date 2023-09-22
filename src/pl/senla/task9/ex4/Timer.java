package pl.senla.task9.ex4;

import java.time.LocalTime;

public class Timer implements Runnable{

    private final long interval;

    public Timer(int interval) {
        this.interval = interval;
    }


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(interval * 1000);
                LocalTime time = LocalTime.now();
                System.out.println("Timer: " + time);
            } catch (InterruptedException e) {
                System.out.println("Thread Timer is interrupted.");
            }
        }
    }
}
