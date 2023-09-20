package pl.senla.task9.ex3;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Thread.*;
import static pl.senla.task9.ex3.Constant.MAX_BUFFER_CAPACITY;

public class Factory {

    private final Queue<Integer> buffer = new ArrayDeque<>();

    private static Factory numberFactory;

    private Factory(){

    }

    public static Factory getNumberFactory() {
        if (numberFactory == null) {
            numberFactory = new Factory();
        }
        return numberFactory;
    }

    public synchronized void produceNumber() throws InterruptedException {
        if (buffer.size() >= MAX_BUFFER_CAPACITY) {
            wait();
        }
        Integer number = generateNumber();
        sleep(800);
        System.out.println("Produced: " + number);
        buffer.add(number);
        System.out.println("quantity in buffer: " + buffer.size());
        notify();
    }

    public synchronized void consumeNumber() throws InterruptedException {
        if (buffer.isEmpty()) {
            wait();
        }
        Integer number = buffer.poll();
        sleep(1000);
        System.out.println("Consumed: " + number);
        notify();
    }

    private int generateNumber() {
        return (int) ((Math.random() + 1) * 100);
    }
}
