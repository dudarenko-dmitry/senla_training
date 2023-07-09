package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class RoomItem3 implements MenuItem {

    private final String nameItem;

    public RoomItem3() {
        this.nameItem = "3. Create new Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
