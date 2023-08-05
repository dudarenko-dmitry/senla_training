package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item3SortRoomsByLevel implements MenuItem {

    private final String nameItem;

    public Item3SortRoomsByLevel() {
        this.nameItem = "3. List of rooms by number of stars.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
