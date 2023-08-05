package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class ImportExportMenuItem8 implements MenuItem {

    private final String nameItem;

    public ImportExportMenuItem8() {
        this.nameItem = "8. Export (save) Orders' and Services' (RoomReservation only) information to file.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
