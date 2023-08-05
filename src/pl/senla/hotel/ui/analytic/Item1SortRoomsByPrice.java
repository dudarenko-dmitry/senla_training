package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item1SortRoomsByPrice implements MenuItem {

    private final String nameItem;

    public Item1SortRoomsByPrice() {
        this.nameItem = "1. List of rooms sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
