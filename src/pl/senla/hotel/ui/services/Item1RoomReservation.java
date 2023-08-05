package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class Item1RoomReservation implements MenuItem {

    private final String nameItem;

    public Item1RoomReservation() {
        this.nameItem = "1. Room Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
