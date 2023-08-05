package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item10CountGuests implements MenuItem {

    private final String nameItem;

    public Item10CountGuests() {
        this.nameItem = "10. Total number of guests.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
