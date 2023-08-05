package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem7 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem7() {
        this.nameItem = "7. Import (load) Orders' and Services' information from file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
