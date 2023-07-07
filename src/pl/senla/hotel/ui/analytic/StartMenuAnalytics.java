package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuAnalytics implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuAnalytics() {
        this.navigator = new NavigatorAnalytics();
        this.executor = new ExecutorAnalytics();
    }

    @Override
    public void runMenu() {
        while (true){
            navigator.buildMenu();
            int userChoice = navigator.makeChoice();
            executor.execute(userChoice);
        }
    }
}
