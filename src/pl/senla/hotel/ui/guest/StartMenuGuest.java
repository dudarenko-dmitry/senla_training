package pl.senla.hotel.ui.guest;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuGuest implements StartMenu {

    @GetInstance(beanName = "NavigatorGuest")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorGuest")
    private Executor executor;

    public StartMenuGuest() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true) {
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
