package pl.senla.hotel.UI.hotelfacilities;

import pl.senla.hotel.UI.Action;
import pl.senla.hotel.UI.Menu;
import pl.senla.hotel.UI.MenuItem;

public class HotelFasilitiesItem3 extends MenuItem implements Action {

    private final String nameItem = "3. Transport operations. ";
    private final Menu nextMenu = null; // TODO // what is it?

    @Override
    public void execute() {
        System.out.println("Do something 3...");
        //        startMenuHotelFacilities();
    }
}
