package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuAnalytics implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuAnalytics(Configuration appConfiguration) {
        this.navigator = NavigatorAnalytics.getNavigatorAnalytics();
        this.executor = ExecutorAnalytics.getExecutorAnalytics(appConfiguration);
    }

    public static StartMenu getStartMenuAnalytics(Configuration appConfiguration){
        if (startMenu == null) {
            startMenu = new StartMenuAnalytics(appConfiguration);
        }
        return startMenu;
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
