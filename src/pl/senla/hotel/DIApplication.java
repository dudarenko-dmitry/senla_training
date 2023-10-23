package pl.senla.hotel;

import pl.senla.hotel.annotations.config.ConfigPropertyAnnotationLoader;
import pl.senla.hotel.annotations.di.DIContext;
import pl.senla.hotel.entity.SavedHotel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DIApplication {

    private static DIApplication application;
    private DIApplication() {}
    public static synchronized DIApplication getApplication() {
        if (application == null) {
            application = new DIApplication();
        }
        return application;
    }

    public static void run(String configDirectory, String configName) throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException {
        DIContext context = DIContext.getContext();
        loadAnnotatedProperties(configDirectory, configName);
        context.createDIContainer();
        context.injectValuesFromDIContainer();
        loadHotelData();
        runApplication(context);

    }

    private static void runApplication(DIContext context) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Object startPoint = context.getStartPoint();
        Method startMethod = context.getStartMethod();
        startMethod.invoke(startPoint.getClass().getConstructor().newInstance());
    }

    private static void loadAnnotatedProperties(String configDirectory, String configName)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ConfigPropertyAnnotationLoader configLoader =
                ConfigPropertyAnnotationLoader.getConfigPropertyAnnotationLoader
                        (configDirectory, configName);
        configLoader.load();
        System.out.println("Config's props loading is complete\n");
    }

    private static void loadHotelData() {
        System.out.println("Start saved hotel's data loading");
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();
    }
}
