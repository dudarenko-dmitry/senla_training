package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem6 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem6() {
        this.nameItem = "6. Export (save) Guests' information to file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
