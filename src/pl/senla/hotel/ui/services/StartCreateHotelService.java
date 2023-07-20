package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;

public class StartCreateHotelService {

    private final Navigator navigator;
    private final ExecutorCreateHotelService executor;

    public StartCreateHotelService() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorCreateHotelService();
    }

    public boolean runMenu(int idGuest) {
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            System.out.println(CONSOLE_CREATE_SERVICE + executor.createHotelServiceForGuest(idGuest, userChoice));
        } while (userChoice != 0);
        return true;
    }
}
