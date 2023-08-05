package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class Item5DeleteGuest implements MenuItem {

    private final String nameItem;

    public Item5DeleteGuest() {
        this.nameItem = "5. Delete Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
