package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item5SortAvailableRoomsByCapacity implements MenuItem {

    private final String nameItem;

    public Item5SortAvailableRoomsByCapacity() {
        this.nameItem = "5. List of available rooms sort by capacity.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
