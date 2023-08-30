package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class Item2ReadRoom implements MenuItem {

    private final String nameItem;

    public Item2ReadRoom() {
        this.nameItem = "2. Read Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
