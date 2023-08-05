package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item7GuestsSortedByNameAndRooms implements MenuItem {

    private final String nameItem;

    public Item7GuestsSortedByNameAndRooms() {
        this.nameItem = "7. List of guests and their rooms sort alphabetically.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
