package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item2GuestOperations implements MenuItem {

    private final String nameItem;

    public Item2GuestOperations() {
        this.nameItem = "2. Guests operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
