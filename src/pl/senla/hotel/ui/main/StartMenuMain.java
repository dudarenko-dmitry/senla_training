package pl.senla.hotel.ui.main;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuMain implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuMain(Configuration appConfiguration) {
        this.navigator = NavigatorMainMenu.getNavigator();
        this.executor = ExecutorMain.getExecutor(appConfiguration);
    }

    public static StartMenu getStartMenu(Configuration appConfiguration) {
        if (startMenu == null) {
            startMenu = new StartMenuMain(appConfiguration);
        }
        return startMenu;
    }

    @Override
    public void runMenu() {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
