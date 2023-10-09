package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuHotelFacilities implements StartMenu {

    private static StartMenu startMenu;
    @GetInstance(beanName = "NavigatorHotelFacilities")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorHotelFacilities")
    private final Executor executor;

    private StartMenuHotelFacilities(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Navigator navigator, Executor executor){
        if (startMenu == null) {
            startMenu = new StartMenuHotelFacilities(navigator, executor);
        }
        return startMenu;
    }

    public void runMenu() throws IllegalAccessException {
        while (true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
