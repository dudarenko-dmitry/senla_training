package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class HotelServiceItem3 implements MenuItem {

    private final String nameItem;

    public HotelServiceItem3() {
        this.nameItem = "3. Transfer Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
