package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

public class RoomLevelItem1 implements MenuItem {

    private final String nameItem;

    public RoomLevelItem1() {
        this.nameItem = "1. Economy 1*";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
