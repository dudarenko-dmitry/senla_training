package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem5 implements MenuItem {

    private final String nameItem;

    public OrderItem5() {
        this.nameItem = "5. Delete Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
