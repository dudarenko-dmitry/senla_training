package pl.senla.hotel.UI.roomlevel;

import pl.senla.hotel.UI.MenuItem;

public class RoomLevelItem2 implements MenuItem {

    private final String nameItem;

    public RoomLevelItem2() {
        this.nameItem = "2. Standard 2**";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
