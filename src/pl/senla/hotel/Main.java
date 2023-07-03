package pl.senla.hotel;

import pl.senla.hotel.controller.Console;
import pl.senla.hotel.controller.ConsoleUI;

public class Main {

    public static void main(String[] args) {

//        Console consoleCollection = new ConsoleCollection(); // version 1 (without UI)
        Console consoleCollection = new ConsoleUI(); // version 2 (with UI)
        consoleCollection.startMainMenu();
    }
}
