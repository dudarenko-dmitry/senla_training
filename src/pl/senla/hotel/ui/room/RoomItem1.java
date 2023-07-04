package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem1 implements MenuItem {

    private final String nameItem;

    public RoomItem1() {
        this.nameItem = "1. Read all Rooms.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
