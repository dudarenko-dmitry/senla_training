package pl.senla.hotel;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.ie.file.DataProcessorFileEntity;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

public class Main {

    public static void main(String[] args) {

        AppConfiguration appConfiguration = AppConfiguration.getAppConfiguration();

        // !!!!!!!!!!     USE ONLY ONE VERSION at once      !!!!!!!!!!
        // version 3 (load Application's data from files)
        DataProcessor dataProcessor = DataProcessorFileEntity.getDataProcessor();
        dataProcessor.loadAllEntities();

        // version 4 (load Application's state by Serialization)
        // SavedHotel hotel = new SavedHotel(appConfiguration);
        // hotel.initializeHotel();

        // version 5 (Load configuration using Annotations)


        StartMenu startMenuMain = StartMenuMain.getStartMenu(appConfiguration);
        startMenuMain.runMenu();
    }
}

