package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
