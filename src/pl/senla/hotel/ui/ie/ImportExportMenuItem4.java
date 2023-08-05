package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem4 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem4() {
        this.nameItem = "4. Export (save) Rooms' information from file (works only for Hotel Facility - ROOM).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
