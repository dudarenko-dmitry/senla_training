package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem4 implements MenuItem {

    private final String nameItem;

    public OrderItem4() {
        this.nameItem = "4. Update Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
