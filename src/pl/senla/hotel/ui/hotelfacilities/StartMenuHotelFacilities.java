package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuHotelFacilities implements StartMenu {

    @GetInstance(beanName = "NavigatorHotelFacilities")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorHotelFacilities")
    private Executor executor;

    public StartMenuHotelFacilities() {}

    public void runMenu() throws IllegalAccessException {
        while (true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
