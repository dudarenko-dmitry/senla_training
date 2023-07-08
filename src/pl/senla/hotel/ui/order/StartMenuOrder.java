package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuOrder implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuOrder() {
        this.navigator = new NavigatorOrder();
        this.executor = new ExecutorOrder();
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
