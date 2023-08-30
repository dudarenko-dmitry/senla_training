package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item2ExportAllData implements MenuItem {

    private final String nameItem;

    public Item2ExportAllData() {
        this.nameItem = "2. Export (save) all application's Entities to file (use before EXIT application).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
