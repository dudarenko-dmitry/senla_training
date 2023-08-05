package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

public class Item2RoomStandard implements MenuItem {

    private final String nameItem;

    public Item2RoomStandard() {
        this.nameItem = "2. Standard 2**";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
