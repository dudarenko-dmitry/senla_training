package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class HotelServiceItem0 implements MenuItem {

    private final String nameItem;

    public HotelServiceItem0() {
        this.nameItem = "0. Save List and Quit to Order menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
