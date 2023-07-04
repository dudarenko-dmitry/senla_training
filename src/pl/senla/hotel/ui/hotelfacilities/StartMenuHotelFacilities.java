package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuHotelFacilities implements StartMenu {

    private final Navigator navigator;
    private final Executor executor;

    public StartMenuHotelFacilities() {
        this.navigator = new NavigatorHotelFacilities();
        this.executor = new ExecutorHotelFacilities();
    }

    public void runMenu() {
        while (true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
