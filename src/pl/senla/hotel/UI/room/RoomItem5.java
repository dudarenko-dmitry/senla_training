package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
