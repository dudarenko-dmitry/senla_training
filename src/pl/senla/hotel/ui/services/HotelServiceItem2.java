package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class HotelServiceItem2 implements MenuItem {

    private final String nameItem;

    public HotelServiceItem2() {
        this.nameItem = "2. Restaurant Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
