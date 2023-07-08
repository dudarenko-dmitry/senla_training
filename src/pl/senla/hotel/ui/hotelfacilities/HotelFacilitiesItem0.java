package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class HotelFacilitiesItem0 implements MenuItem {

    private final String nameItem;

    public HotelFacilitiesItem0() {
        nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
