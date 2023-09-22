package pl.senla.task9.ex4;

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer(3);
        Thread threadTimer = new Thread(timer);
        threadTimer.setDaemon(true);
        threadTimer.start();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Main is interrupted...");
            }
            System.out.println("Main --> " + i);
        }
        System.out.println("All actions are finished.");
    }
}
