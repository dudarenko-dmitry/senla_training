package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class Item1ReadAllRooms implements MenuItem {

    private final String nameItem;

    public Item1ReadAllRooms() {
        this.nameItem = "1. Read all Rooms.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
