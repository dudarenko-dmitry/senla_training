package pl.senla.hotel.ui.room;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuRoom implements StartMenu {

    @GetInstance(beanName = "NavigatorRoom")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorRoom")
    private Executor executor;

    public StartMenuRoom() {}

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
