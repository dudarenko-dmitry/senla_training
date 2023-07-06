package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
