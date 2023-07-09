package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuRoom implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuRoom() {
        this.navigator = new NavigatorRoom();
        this.executor = new ExecutorRoom();
    }

    public void runMenu() {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
