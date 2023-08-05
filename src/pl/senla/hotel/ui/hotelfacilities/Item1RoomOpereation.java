package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class Item1RoomOpereation implements MenuItem {

    private final String nameItem;

    public Item1RoomOpereation() {
        nameItem = "1. Room operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
