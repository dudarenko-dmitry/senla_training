package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class Item3TransferReservation implements MenuItem {

    private final String nameItem;

    public Item3TransferReservation() {
        this.nameItem = "3. Transfer Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
