package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem2 implements MenuItem {

    private final String nameItem;

    public RoomItem2() {
        this.nameItem = "2. Read Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
