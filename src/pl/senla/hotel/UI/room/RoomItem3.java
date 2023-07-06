package pl.senla.hotel.UI.room;

import pl.senla.hotel.UI.MenuItem;

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
