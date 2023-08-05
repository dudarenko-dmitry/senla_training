package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class Item2ReadGuest implements MenuItem {

    private final String nameItem;

    public Item2ReadGuest() {
        this.nameItem = "2. Read Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
