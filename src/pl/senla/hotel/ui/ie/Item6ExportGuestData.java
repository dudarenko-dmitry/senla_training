package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item6ExportGuestData implements MenuItem {

    private final String nameItem;

    public Item6ExportGuestData() {
        this.nameItem = "6. Export (save) Guests' information to file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
