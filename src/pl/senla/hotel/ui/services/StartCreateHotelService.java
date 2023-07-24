package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.Navigator;

import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_CREATE_SERVICE;

public class StartCreateHotelService {

    private static StartCreateHotelService startCreateHotelService;
    private final Navigator navigator;
    private final ExecutorCreateHotelService executor;

    private StartCreateHotelService() {
        this.navigator = NavigatorHotelService.getNavigatorHotelService();
        this.executor = ExecutorCreateHotelService.getExecutorCreateHotelService();
    }

    public static StartCreateHotelService getStartCreateHotelService(){
        if (startCreateHotelService == null) {
            startCreateHotelService = new StartCreateHotelService();
        }
        return startCreateHotelService;
    }

    public boolean runMenu(int idOrder, int idGuest) {
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            System.out.println(CONSOLE_CREATE_SERVICE + executor.createHotelServiceForGuest(idOrder, idGuest, userChoice));
        } while (userChoice != 0);
        return true;
    }
}
