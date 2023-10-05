package pl.senla.hotel;

import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        // Load configuration using Properties-file
//        AppConfiguration appConfiguration = AppConfiguration.getAppConfiguration();

        // !!!!!!!!!!     USE ONLY ONE VERSION at once      !!!!!!!!!!
        // version 3 (load Application's data from files)
//        DataProcessor dataProcessor = DataProcessorFileEntity.getDataProcessor();
//        dataProcessor.loadAllEntities();

        // version 4 (load Application's state by Serialization)
//         SavedHotel hotel = new SavedHotel(appConfiguration);
//         hotel.initializeHotel();

//        StartMenu startMenuMain = StartMenuMain.getStartMenu(appConfiguration); //without annotations
        StartMenu startMenuMain = StartMenuMain.getStartMenu(); // using annotations
        startMenuMain.runMenu();
    }
}

