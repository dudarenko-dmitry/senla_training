package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

public class Item3RoomLux implements MenuItem {

    private final String nameItem;

    public Item3RoomLux() {
        this.nameItem = "3. Lux 3***";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
