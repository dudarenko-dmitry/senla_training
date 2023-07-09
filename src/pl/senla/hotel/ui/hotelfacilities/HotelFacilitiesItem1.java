package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class HotelFacilitiesItem1 implements MenuItem {

    private final String nameItem;

    public HotelFacilitiesItem1() {
        nameItem = "1. Room operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
