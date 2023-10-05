package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.config.ConfigPropertyAnnotated;
import pl.senla.hotel.annotations.config.ConfigPropertyAnnotationLoader;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuMain implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuMain() throws IllegalAccessException {
        ConfigPropertyAnnotated appConfigAnnotated = ConfigPropertyAnnotated.getConfigPropertyAnnotated();
        ConfigPropertyAnnotationLoader configLoader =
                new ConfigPropertyAnnotationLoader("C://IT/senla_training/src/pl/senla/hotel/resources/",
                        "hotel.properties");
        configLoader.load(appConfigAnnotated);
        SavedHotel hotel = new SavedHotel();
        hotel.initializeHotel();
        this.navigator = NavigatorMainMenu.getNavigator();
        this.executor = ExecutorMain.getExecutor();
    }

    public static StartMenu getStartMenu() throws IllegalAccessException {
        if (startMenu == null) {
            startMenu = new StartMenuMain();
        }
        return startMenu;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
