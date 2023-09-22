package pl.senla.task9.ex3;

public class Consumer implements Runnable{

    private final Factory numberFactory;

    public Consumer() {
        this.numberFactory = Factory.getNumberFactory();
    }

    @Override
    public void run() {
        while (true) {
            try {
                numberFactory.consumeNumber();
            } catch (InterruptedException e) {
                System.out.println("Error in Consuming.");
                throw new RuntimeException(e);
            }
        }
    }
}
