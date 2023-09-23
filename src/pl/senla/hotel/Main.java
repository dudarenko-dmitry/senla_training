package pl.senla.hotel;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.ie.file.DataProcessorFileEntity;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

public class Main {

    public static void main(String[] args) {

        // use to save new Properties
//        PropertiesLoader loader = new AppPropertiesLoader();
//        loader.saveConfiguration();

        // load Properties while starting program
        AppConfiguration appConfiguration = AppConfiguration.getAppConfiguration();
        /*
        !!!!!!!!!!     USE ONLY ONE VERSION at once      !!!!!!!!!!

          previous versions:
        // version 1 (without UI)
        Console consoleCollection = new ConsoleCollection();

        // version 2 (with UI)
        Console consoleCollection = new ConsoleUI(); // version 2 (with UI)
        consoleCollection.startMainMenu(); // version 2 (with UI)
        */

        // version 3 (load Application's data from files)
        DataProcessor dataProcessor = DataProcessorFileEntity.getDataProcessor();
        dataProcessor.loadAllEntities();

        // version 4 (load Application's state by Serialization)
//        SavedHotel hotel = new SavedHotel(appConfiguration);
//        hotel.initializeHotel();

        StartMenu startMenuMain = StartMenuMain.getStartMenu(appConfiguration); // version 3 (UI with separate menus for every operation)
        startMenuMain.runMenu();
    }
}

