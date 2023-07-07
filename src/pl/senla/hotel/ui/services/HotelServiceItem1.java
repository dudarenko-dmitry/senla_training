package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class HotelServiceItem1 implements MenuItem {

    private final String nameItem;

    public HotelServiceItem1() {
        this.nameItem = "1. Room Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
