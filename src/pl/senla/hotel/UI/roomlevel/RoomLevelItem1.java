package pl.senla.hotel.UI.roomlevel;

import pl.senla.hotel.UI.MenuItem;

public class RoomLevelItem1 implements MenuItem {

    private String nameItem;

    public RoomLevelItem1() {
        this.nameItem = "1. Economy 1*";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
