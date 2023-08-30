package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class Item5DeleteRoom implements MenuItem {

    private final String nameItem;

    public Item5DeleteRoom() {
        this.nameItem = "5. Delete Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
