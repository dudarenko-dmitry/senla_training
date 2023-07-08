package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem1 implements MenuItem {

    private final String nameItem;

    public OrderItem1() {
        this.nameItem = "1. Read all Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
