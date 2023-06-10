package pl.senla.lecture3.task1;

public class Number {

    private int numberRandom;

    public Number() {
        int maxNumber = 999;
        int minNumber = 100;
        while (numberRandom < minNumber){
            this.numberRandom = new java.util.Random().nextInt(maxNumber);
        }
    }

    public int getNumberRandom() {
        return numberRandom;
    }
}
