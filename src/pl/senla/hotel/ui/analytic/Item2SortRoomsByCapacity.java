package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item2SortRoomsByCapacity implements MenuItem {

    private final String nameItem;

    public Item2SortRoomsByCapacity() {
        this.nameItem = "2. List of rooms by capacity.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
