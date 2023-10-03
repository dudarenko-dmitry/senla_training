package pl.senla.hotel.ui.guest;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuGuest implements StartMenu {

    @GetInstance(beanName = "NavigatorGuest")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorGuest")
    private Executor executor;

    public StartMenuGuest() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        int menuPoint = 1;
        while (menuPoint != 0) {
            navigator.buildMenu();
            menuPoint = userChoice.makeChoice();
            if (menuPoint != 0) {
                executor.execute(menuPoint);
            }
        }
    }
}
