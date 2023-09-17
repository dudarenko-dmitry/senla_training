package pl.senla.task9.ex3;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        producer.interrupt();
        consumer.interrupt();
        System.out.println("Work complete.");

    }
}
