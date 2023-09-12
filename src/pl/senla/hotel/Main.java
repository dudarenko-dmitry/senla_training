package pl.senla.hotel;

import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

public class Main {

    public static void main(String[] args) {

        /*
          previous versions:
        // version 1 (without UI)
        Console consoleCollection = new ConsoleCollection();

        // version 2 (with UI)
        Console consoleCollection = new ConsoleUI(); // version 2 (with UI)
        consoleCollection.startMainMenu(); // version 2 (with UI)

        // version 3 (load Application's state from files)
        DataProcessor dataProcessor = DataProcessorFile.getDataProcessor();
        dataProcessor.loadAllEntities();

        // use to save new Properties
        PropertiesLoader loader = new AppPropertiesLoader();
        loader.saveConfiguration();
         */

        // version 4 (load Application's state by Serialization)
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();

        StartMenu startMenuMain = StartMenuMain.getStartMenu(); // version 3 (UI with separate menus for every operation)
        startMenuMain.runMenu();
    }
}

