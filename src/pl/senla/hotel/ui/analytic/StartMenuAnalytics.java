package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuAnalytics implements StartMenu {

    private static StartMenu startMenu;
    @GetInstance(beanName = "NavigatorAnalytics")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorAnalytics")
    private final Executor executor;

    private StartMenuAnalytics(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Navigator navigator, Executor executor){
        if (startMenu == null) {
            startMenu = new StartMenuAnalytics(navigator, executor);
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
