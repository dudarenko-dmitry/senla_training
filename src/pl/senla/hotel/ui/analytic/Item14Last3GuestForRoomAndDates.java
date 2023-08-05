package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item14Last3GuestForRoomAndDates implements MenuItem {

    private final String nameItem;

    public Item14Last3GuestForRoomAndDates() {
        this.nameItem = "14. View the last 3 guests of the room and the dates of their stay.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
