package pl.senla.hotel.ui.guest;

import pl.senla.hotel.ui.MenuItem;

public class Item4UpdateGuest implements MenuItem {

    private final String nameItem;

    public Item4UpdateGuest() {
        this.nameItem = "4. Update Guest.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
