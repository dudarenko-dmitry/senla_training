package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class Item3CreateRoom implements MenuItem {

    private final String nameItem;

    public Item3CreateRoom() {
        this.nameItem = "3. Create new Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
