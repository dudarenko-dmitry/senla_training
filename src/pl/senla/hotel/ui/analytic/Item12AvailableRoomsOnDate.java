package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item12AvailableRoomsOnDate implements MenuItem {

    private final String nameItem;

    public Item12AvailableRoomsOnDate() {
        this.nameItem = "12. List of rooms that will be available on a certain date in the future.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
