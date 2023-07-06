package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.Executor;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.StartMenu;

public class StartMenuRoom implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuRoom() {
        this.navigator = new NavigatorRoom();
        this.executor = new ExecutorRoom();
    }

    public void runMenu() {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        executor.execute(userSelection);
    }
}
