package pl.senla.task9.ex3;

import static pl.senla.task9.ex3.Constant.MAX_PRODUCTION;

public class Consumer implements Runnable{

    private final Factory numberFactory;
    private Integer counter = 0;

    public Consumer() {
        this.numberFactory = Factory.getNumberFactory();
    }

    @Override
    public void run() {
        while (counter < MAX_PRODUCTION) {
            try {
                numberFactory.consumeNumber();
                counter++;
                System.out.println("Total consumption: " + counter);
            } catch (InterruptedException e) {
                System.out.println("Error in Consuming.");
                throw new RuntimeException(e);
            }
        }
        System.out.println("<<< All number were consumed >>>");
    }
}
