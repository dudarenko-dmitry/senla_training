package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuHotelFacilities implements StartMenu {

    private static StartMenu startMenu;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuHotelFacilities() {
        this.navigator = new NavigatorHotelFacilities();
        this.executor = ExecutorHotelFacilities.getExecutorHotelFacilities();
    }

    public static StartMenu getStartMenuHotelFacilities(){
        if (startMenu == null) {
            startMenu = new StartMenuHotelFacilities();
        }
        return startMenu;
    }

    public void runMenu() {
        while (true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
