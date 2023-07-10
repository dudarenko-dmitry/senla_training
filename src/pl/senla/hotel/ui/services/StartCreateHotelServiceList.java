package pl.senla.hotel.ui.services;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Navigator;

import java.util.List;

public class StartCreateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorCreateHotelServiceList executor;

    public StartCreateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorCreateHotelServiceList();
    }

    //don't work with PRIVATE access modifier. WHY?
    public List<HotelService> runMenu(int idGuest) {
        List<HotelService> guestServices;
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            guestServices = executor.createHotelServiceList(idGuest, userChoice); //
        } while (userChoice != 0);
        return guestServices; //return RoomReservation
    }
}
