package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item4ExportRoomData implements MenuItem {

    private final String nameItem;

    public Item4ExportRoomData() {
        this.nameItem = "4. Export (save) Rooms' information from file (works only for Hotel Facility - ROOM).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
