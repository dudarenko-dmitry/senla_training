package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuMain implements StartMenu {

    private static StartMenu startMenu;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executor;

    private StartMenuMain(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Navigator navigator, Executor executor) throws IllegalAccessException {
        if (startMenu == null) {
            startMenu = new StartMenuMain(navigator, executor);
        }
        return startMenu;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
