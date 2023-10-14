package pl.senla.hotel;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.annotations.config.ConfigPropertyAnnotationLoader;
import pl.senla.hotel.annotations.di.*;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Main {

    @GetInstance(beanName = "NavigatorMainMenu")
    private static Executor executor;
    @GetInstance(beanName = "ExecutorMain")
    private static Navigator navigator;

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
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

        /* version 2 */
        Reflections reflections = new Reflections("pl.senla.hotel",
                new FieldAnnotationsScanner(),
                new TypeAnnotationsScanner(),
                new SubTypesScanner());
        Set<Field> annotatedPropertyFields = reflections.getFieldsAnnotatedWith(ConfigProperty.class);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(AppComponent.class);
        Set<Field> annotatedFields = reflections.getFieldsAnnotatedWith(GetInstance.class);

        ConfigPropertyAnnotationLoader configLoader =
                new ConfigPropertyAnnotationLoader("C://IT/senla_training/src/pl/senla/hotel/resources/",
                        "hotel.properties");
        configLoader.load(annotatedPropertyFields);

        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();

//        DI injector = DI.getSingletonInstance();
//        injector.inject(annotatedClasses);

//        StartMenu startMenuMain = StartMenuMain.getSingletonInstance(navigator, executor); // using annotations
//        startMenuMain.runMenu();

//        -------------------------------
        /* versicn 1:
        ConfigPropertyAnnotated appConfigAnnotated = ConfigPropertyAnnotated.getSingletonInstance();
        ConfigPropertyAnnotationLoader configLoader =
                new ConfigPropertyAnnotationLoader("C://IT/senla_training/src/pl/senla/hotel/resources/",
                        "hotel.properties");
        configLoader.load(appConfigAnnotated);
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();

        ClassCollector appClasses = ClassCollector.getInstanceLoader();
//        DIContainer beanContainer = DIContainer.getSingletonInstance();
//        beanContainer.createDI();
        DI injector = DI.getSingletonInstance();
//        injector.inject(appClasses.getAllClassesFrom("pl.senla.hotel"));
        injector.inject(appClasses.getAllClasses("pl.senla.hotel"));

        StartMenu startMenuMain = StartMenuMain.getSingletonInstance(navigator, executor); // using annotations
        startMenuMain.runMenu();
         */

    }
}

