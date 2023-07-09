package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuMain implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuMain() {
        this.navigator = new NavigatorMainMenu();
        this.executor = new ExecutorMain();
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
