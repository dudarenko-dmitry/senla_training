package pl.senla.hotel.ui.main;

import pl.senla.hotel.ui.MenuItem;

public class Item3OrderOperations implements MenuItem {

    private final String nameItem;

    public Item3OrderOperations() {
        this.nameItem = "3. Orders' operations.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
