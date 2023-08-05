package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuMain implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuMain() {
        this.navigator = NavigatorMainMenu.getNavigator();
        this.executor = ExecutorMain.getExecutor();
    }

    public static StartMenu getStartMenu() {
        if (startMenu == null) {
            startMenu = new StartMenuMain();
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
