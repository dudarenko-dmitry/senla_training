package pl.senla.hotel;

import pl.senla.hotel.controller.Console;
import pl.senla.hotel.controller.ConsoleCollection;
import pl.senla.hotel.controller.ConsoleUI;

public class Main {

    public static void main(String[] args) {

//        Console consoleCollection = new ConsoleCollection(); // was
        Console consoleCollection = new ConsoleUI(); // was
        consoleCollection.startMainMenu();
    }
}
