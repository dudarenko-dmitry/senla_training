package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class Item3CreateGuest implements MenuItem {

    private final String nameItem;

    public Item3CreateGuest() {
        this.nameItem = "3. Create new Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
