package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item8GuestsAndRoomsSortedByCheckOut implements MenuItem {

    private final String nameItem;

    public Item8GuestsAndRoomsSortedByCheckOut() {
        this.nameItem = "8. List of guests and their rooms sort by check-out date.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
