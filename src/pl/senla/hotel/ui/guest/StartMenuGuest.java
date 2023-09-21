package pl.senla.hotel.ui.guest;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuGuest implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuGuest(Configuration appConfiguration) {
        this.navigator = NavigatorGuest.getNavigatorGuest();
        this.executor = ExecutorGuest.getExecutorGuest(appConfiguration);
    }

    public static StartMenu getStartMenuGuest(Configuration appConfiguration){
        if (startMenu == null) {
            startMenu = new StartMenuGuest(appConfiguration);
        }
        return startMenu;
    }

    @Override
    public void runMenu() {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
