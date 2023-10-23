package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuMain implements StartMenu {

    @GetInstance(beanName = "NavigatorMainMenu")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorMain")
    private Executor executor;

    public StartMenuMain() {}

    @Override
    public void runMenu() throws IllegalAccessException {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
