package pl.senla.hotel.ui.guest;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuGuest implements StartMenu {

    private static StartMenu startMenu;
    @GetInstance(beanName = "NavigatorGuest")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorGuest")
    private final Executor executor;

    private StartMenuGuest(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Navigator navigator, Executor executor){
        if (startMenu == null) {
            startMenu = new StartMenuGuest(navigator, executor);
        }
        return startMenu;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
