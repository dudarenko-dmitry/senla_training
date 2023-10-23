package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuAnalytics implements StartMenu {

    @GetInstance(beanName = "NavigatorAnalytics")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorAnalytics")
    private Executor executor;

    public StartMenuAnalytics() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        while (true){
            navigator.buildMenu();
            int userChoice = navigator.makeChoice();
            executor.execute(userChoice);
        }
    }
}
