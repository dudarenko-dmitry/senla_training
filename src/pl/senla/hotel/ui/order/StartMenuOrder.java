package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuOrder implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuOrder() {
        this.navigator = NavigatorOrder.getNavigatorOrder();
        this.executor = ExecutorOrder.getExecutorOrder();
    }

    public static StartMenu getStartMenuOrder(){
        if (startMenu == null) {
            startMenu = new StartMenuOrder();
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
