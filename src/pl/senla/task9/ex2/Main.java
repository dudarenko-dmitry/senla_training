package pl.senla.task9.ex2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        First first = new First();
        Second second = new Second();

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Main: process is finished");
    }

}

