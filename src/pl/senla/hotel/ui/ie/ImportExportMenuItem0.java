package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem0 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem0() {
        this.nameItem = "0. Quit to Main Menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
