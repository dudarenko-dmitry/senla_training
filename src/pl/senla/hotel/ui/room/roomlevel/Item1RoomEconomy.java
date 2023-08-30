package pl.senla.hotel.ui.room.roomlevel;

import pl.senla.hotel.ui.MenuItem;

public class Item1RoomEconomy implements MenuItem {

    private final String nameItem;

    public Item1RoomEconomy() {
        this.nameItem = "1. Economy 1*";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
