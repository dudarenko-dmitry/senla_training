package pl.senla.hotel.ui.hotelfacilities;

import pl.senla.hotel.ui.MenuItem;

public class Item2TableOperation implements MenuItem {

    private final String nameItem;

    public Item2TableOperation() {
        nameItem = "2. Table operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
