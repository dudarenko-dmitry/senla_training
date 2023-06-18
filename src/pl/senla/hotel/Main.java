package pl.senla.hotel;

import pl.senla.hotel.controller.Console;
import pl.senla.hotel.controller.ConsoleCollection;

public class Main {

    public static void main(String[] args) {

        Console consoleCollection = new ConsoleCollection();
        consoleCollection.start();
    }
}
