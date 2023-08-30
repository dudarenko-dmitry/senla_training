package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class Item3TransportOperation implements MenuItem {

    private final String nameItem;

    public Item3TransportOperation() {
        nameItem = "3. Transport operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
