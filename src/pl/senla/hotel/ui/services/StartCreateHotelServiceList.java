package pl.senla.hotel.ui.services;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ui.Navigator;

import java.util.ArrayList;
import java.util.List;

public class StartCreateHotelServiceList {

    private final Navigator navigator;
    private final ExecutorCreateHotelServiceList executor;

    public StartCreateHotelServiceList() {
        this.navigator = new NavigatorHotelService();
        this.executor = new ExecutorCreateHotelServiceList();
    }

    //don't work with PRIVATE access modifier. WHY?
    public List<HotelService> runMenu(Guest guest) {
        List<HotelService> guestServices = new ArrayList<>();
        int userChoice;
        do {
            navigator.buildMenu();
            userChoice = navigator.makeChoice();
            guestServices = executor.createHotelServiceList(guestServices, guest, userChoice); //
        } while (userChoice != 0);
        return guestServices; //return RoomReservation
    }
}
