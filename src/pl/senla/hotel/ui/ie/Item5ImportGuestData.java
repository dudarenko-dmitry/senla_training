package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item5ImportGuestData implements MenuItem {

    private final String nameItem;

    public Item5ImportGuestData() {
        this.nameItem = "5. Import (load) Guests' information from file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
