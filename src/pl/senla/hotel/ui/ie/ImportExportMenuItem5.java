package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem5 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem5() {
        this.nameItem = "5. Import (load) Guests' information from file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
