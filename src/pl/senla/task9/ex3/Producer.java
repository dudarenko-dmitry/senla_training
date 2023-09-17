package pl.senla.task9.ex3;

import static pl.senla.task9.ex3.Constant.MAX_PRODUCTION;

public class Producer implements Runnable{

    private final Factory numberFactory;
    private Integer counter = 0;

    public Producer() {
        this.numberFactory = Factory.getNumberFactory();
    }

    @Override
    public void run() {
        while (counter < MAX_PRODUCTION) {
            try {
                numberFactory.produceNumber();
                counter++;
                System.out.println("Total production: " + counter);
            } catch (InterruptedException e) {
                System.out.println("Error in Production");
                throw new RuntimeException(e);
            }
        }
        System.out.println(">>> Production complete <<<");
    }
}
