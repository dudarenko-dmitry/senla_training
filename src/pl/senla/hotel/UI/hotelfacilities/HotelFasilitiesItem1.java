package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Action;
import pl.senla.hotel.UI.Menu;
import pl.senla.hotel.UI.MenuItem;

public class HotelFasilitiesItem1 extends MenuItem implements Action {

    private static final String nameItem = "1. Room operations. ";
    private static final Menu nextMenu = null; // TODO // what is it?

    @Override
    public void execute() {
        System.out.println("Do something 1...");
        //        startMenuHotelFacilities();
    }
}
