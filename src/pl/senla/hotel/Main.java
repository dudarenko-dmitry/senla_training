package pl.senla.hotel;

import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

public class Main {

    public static void main(String[] args) {

        /**
         * previous versions:
        Console consoleCollection = new ConsoleCollection(); // version 1 (without UI)
        Console consoleCollection = new ConsoleUI(); // version 2 (with UI)
        consoleCollection.startMainMenu(); // version 2 (with UI)
         */

        StartMenu startMenuMain = new StartMenuMain(); // version 3 (UI with separate menus for every operation)
        startMenuMain.runMenu();
    }
}
