package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class HotelFacilitiesItem2 implements MenuItem {

    private final String nameItem;

    public HotelFacilitiesItem2() {
        nameItem = "2. Table operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
