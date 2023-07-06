package pl.senla.hotel.UI.main;

import pl.senla.hotel.UI.Executor;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.StartMenu;

public class StartMenuMain implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuMain() {
        this.navigator = new NavigatorMainMenu();
        this.executor = new ExecutorMain();
    }

    @Override
    public void runMenu() {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        executor.execute(userSelection);
    }
}
