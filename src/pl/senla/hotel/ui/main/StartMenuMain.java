package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.annotations.di.StartPoint;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
@StartPoint
public class StartMenuMain implements StartMenu {

    @GetInstance(beanName = "NavigatorMainMenu")
    private Navigator navigator;
    @GetInstance(beanName = "UserChoice")
    private Choice userChoice;
    @GetInstance(beanName = "ExecutorMain")
    private Executor executor;

    public StartMenuMain() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        int menuPoint = 1;
        while (menuPoint != 0) {
            navigator.buildMenu();
            menuPoint = userChoice.makeChoice();
            executor.execute(menuPoint);
        }
    }
}
