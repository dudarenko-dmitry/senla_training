package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
