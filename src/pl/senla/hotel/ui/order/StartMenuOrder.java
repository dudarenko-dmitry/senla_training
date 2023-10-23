package pl.senla.hotel.ui.order;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuOrder implements StartMenu {

    @GetInstance(beanName = "NavigatorOrder")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorOrder")
    private Executor executor;

    public StartMenuOrder() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true) {
            navigator.buildMenu();
            int userChoice = navigator.makeChoice();
            executor.execute(userChoice);
        }
    }
}
