package pl.senla.lecture3.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final Number numberRandom = new Number();
        int number = numberRandom.getNumberRandom();

        System.out.println("Random number: " + number);

        int number1 = number/100;
        int number2 = number/10 - number1 * 10;
        int number3 = number - number1 * 100 - number2 * 10;

        System.out.println("Digit 1: " + number1);
        System.out.println("Digit 2: " + number2);
        System.out.println("Digit 3: " + number3);

        int[] digits = {number1, number2, number3};

        int maxDigit = Arrays.stream(digits).max().getAsInt();
        System.out.println("max digit: " + maxDigit);

    }
}
