package pl.senla.hotel;

import pl.senla.hotel.annotations.config.ConfigPropertyAnnotationLoader;
import pl.senla.hotel.annotations.di.*;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

@AppComponent
public class Main {

//    @GetInstance(beanName = "NavigatorMainMenu")
//    private static Executor executor;
//    @GetInstance(beanName = "ExecutorMain")
//    private static Navigator navigator;
    @GetInstance(beanName = "StartMenuMain")
    private static StartMenu startMenuMain;

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, InstantiationException {

        System.out.println("Start Config's props loading");
        ConfigPropertyAnnotationLoader configLoader =
                new ConfigPropertyAnnotationLoader("C://IT/senla_training/src/pl/senla/hotel/resources/",
                        "hotel.properties");
        configLoader.load();
        System.out.println("Config's props loading is complete\n");

        System.out.println("Start DIContext creating");
        DIContext context = new DIContext();
        context.createDIContainer();

        System.out.println("Start saved hotel data loading");
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();

//        StartMenu startMenuMain = StartMenuMain.getSingletonInstance(navigator, executor); // using annotations
        startMenuMain.runMenu();

    }
}

