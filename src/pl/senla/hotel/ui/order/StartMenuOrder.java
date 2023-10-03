package pl.senla.hotel.ui.order;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuOrder implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuOrder(Configuration appConfiguration) {
        this.navigator = NavigatorOrder.getNavigatorOrder();
        this.executor = ExecutorOrder.getExecutorOrder(appConfiguration);
    }

    public static StartMenu getStartMenuOrder(Configuration appConfiguration){
        if (startMenu == null) {
            startMenu = new StartMenuOrder(appConfiguration);
        }
        return startMenu;
    }
    @Override
    public void runMenu() {
        while (true) {
            navigator.buildMenu();
            int userChoice = navigator.makeChoice();
            executor.execute(userChoice);
        }
    }
}
