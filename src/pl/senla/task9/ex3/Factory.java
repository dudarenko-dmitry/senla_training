package pl.senla.task9.ex3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.*;
import static pl.senla.task9.ex3.Constant.MAX_BUFFER_CAPACITY;

public class Factory {

    private final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(MAX_BUFFER_CAPACITY, true);

    private static Factory numberFactory;

    private Factory(){

    }

    public static Factory getNumberFactory() {
        if (numberFactory == null) {
            numberFactory = new Factory();
        }
        return numberFactory;
    }

    public void produceNumber() throws InterruptedException {
        Integer number = generateNumber();
        System.out.println("Produced: " + number);
        buffer.put(number);
        System.out.println("quantity in buffer: " + buffer.size());
        sleep(800);
    }

    public void consumeNumber() throws InterruptedException {
        Integer number = buffer.take();
        System.out.println("Consumed: " + number);
        sleep(1000);
    }

    private int generateNumber() {
        return (int) ((Math.random() + 1) * 100);
    }
}
