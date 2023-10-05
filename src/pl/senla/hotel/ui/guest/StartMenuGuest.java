package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuGuest implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuGuest() {
        this.navigator = NavigatorGuest.getNavigatorGuest();
        this.executor = ExecutorGuest.getExecutorGuest();
    }

    public static StartMenu getStartMenuGuest(){
        if (startMenu == null) {
            startMenu = new StartMenuGuest();
        }
        return startMenu;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
