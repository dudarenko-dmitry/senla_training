package pl.senla.hotel.ui.services;

import pl.senla.hotel.ui.MenuItem;

public class Item2RestaurantReservation implements MenuItem {

    private final String nameItem;

    public Item2RestaurantReservation() {
        this.nameItem = "2. Restaurant Reservation.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
