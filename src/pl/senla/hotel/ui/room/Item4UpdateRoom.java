package pl.senla.hotel.ui.room;

import pl.senla.hotel.ui.MenuItem;

public class Item4UpdateRoom implements MenuItem {

    private final String nameItem;

    public Item4UpdateRoom() {
        this.nameItem = "4. Update Room.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
