package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.MenuItem;

public class Item3ImportRoomData implements MenuItem {

    private final String nameItem;

    public Item3ImportRoomData() {
        this.nameItem = "3. Import (load) Rooms' information from file (works only for Hotel Facility - ROOM).";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
