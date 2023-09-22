package pl.senla.task9.ex3;

public class Producer implements Runnable{

    private final Factory numberFactory;

    public Producer() {
        this.numberFactory = Factory.getNumberFactory();
    }

    @Override
    public void run() {
        while (true) {
            try {
                numberFactory.produceNumber();
            } catch (InterruptedException e) {
                System.out.println("Error in Production");
                throw new RuntimeException(e);
            }
        }
    }
}
