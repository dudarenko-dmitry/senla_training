package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuAnalytics implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuAnalytics() {
        this.navigator = NavigatorAnalytics.getNavigatorAnalytics();
        this.executor = ExecutorAnalytics.getExecutorAnalytics();
    }

    public static StartMenu getStartMenuAnalytics(){
        if (startMenu == null) {
            startMenu = new StartMenuAnalytics();
        }
        return startMenu;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true){
            navigator.buildMenu();
            int userChoice = navigator.makeChoice();
            executor.execute(userChoice);
        }
    }
}
