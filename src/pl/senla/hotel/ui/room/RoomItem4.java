package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem4 implements MenuItem {

    private final String nameItem;

    public RoomItem4() {
        this.nameItem = "4. Update Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
