package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class Item1ReadAllGuests implements MenuItem {

    private final String nameItem;

    public Item1ReadAllGuests() {
        this.nameItem = "1. Read all Guests.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
