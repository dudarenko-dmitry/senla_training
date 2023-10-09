package pl.senla.hotel;

import pl.senla.hotel.annotations.config.ConfigPropertyAnnotated;
import pl.senla.hotel.annotations.config.ConfigPropertyAnnotationLoader;
import pl.senla.hotel.annotations.di.ClassCollector;
import pl.senla.hotel.annotations.di.DI;
import pl.senla.hotel.annotations.di.DIContainer;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

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

        ConfigPropertyAnnotated appConfigAnnotated = ConfigPropertyAnnotated.getSingletonInstance();
        ConfigPropertyAnnotationLoader configLoader =
                new ConfigPropertyAnnotationLoader("C://IT/senla_training/src/pl/senla/hotel/resources/",
                        "hotel.properties");
//        configLoader.loadConfiguration(appConfigAnnotated);
        configLoader.load(appConfigAnnotated);
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();

        ClassCollector appClasses = ClassCollector.getInstanceLoader();
        DIContainer beanContainer = DIContainer.getSingletonInstance();
        beanContainer.createDI();
        DI injector = DI.getSingletonInstance();

        injector.inject(appClasses.getAllClassesFrom("pl.senla.hotel"), beanContainer);

        StartMenu startMenuMain = StartMenuMain.getSingletonInstance(); // using annotations
        startMenuMain.runMenu();
    }
}

