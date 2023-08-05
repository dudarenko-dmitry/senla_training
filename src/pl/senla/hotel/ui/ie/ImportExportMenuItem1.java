package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem1 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem1() {
        this.nameItem = "1. Import (load) all application's Entities from file (use after START application).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
