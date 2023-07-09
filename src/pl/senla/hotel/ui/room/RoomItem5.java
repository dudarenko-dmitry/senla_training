package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem5 implements MenuItem {

    private final String nameItem;

    public RoomItem5() {
        this.nameItem = "5. Delete Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
