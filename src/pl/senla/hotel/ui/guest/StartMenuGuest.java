package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuGuest implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuGuest() {
        this.navigator = new NavigatorGuest();
        this.executor = new ExecutorGuest();
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
