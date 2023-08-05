package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class Item2ReadOrder implements MenuItem {

    private final String nameItem;

    public Item2ReadOrder() {
        this.nameItem = "2. Read Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
