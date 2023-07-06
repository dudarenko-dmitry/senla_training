package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Executor;
import pl.senla.hotel.UI.Navigator;
import pl.senla.hotel.UI.StartMenu;

public class StartMenuHotelFacilities implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuHotelFacilities() {
        this.navigator = new NavigatorHotelFacilities();
        this.executor = new ExecutorHotelFacilities();
    }

    public void runMenu() {
        navigator.buildMenu();
        int userSelection = navigator.makeChoice();
        executor.execute(userSelection);
    }
}
