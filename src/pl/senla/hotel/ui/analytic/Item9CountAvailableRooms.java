package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item9CountAvailableRooms implements MenuItem {

    private final String nameItem;

    public Item9CountAvailableRooms() {
        this.nameItem = "9. Total number of available rooms.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
