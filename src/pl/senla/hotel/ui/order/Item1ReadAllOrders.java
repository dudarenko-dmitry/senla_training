package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class Item1ReadAllOrders implements MenuItem {

    private final String nameItem;

    public Item1ReadAllOrders() {
        this.nameItem = "1. Read all Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
