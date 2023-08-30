package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item4SortAvailableRoomsByPrice implements MenuItem {

    private final String nameItem;

    public Item4SortAvailableRoomsByPrice() {
        this.nameItem = "4. List of available rooms sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
