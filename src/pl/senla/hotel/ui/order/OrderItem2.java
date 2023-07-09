package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem2 implements MenuItem {

    private final String nameItem;

    public OrderItem2() {
        this.nameItem = "2. Read Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
