package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem3 implements MenuItem {

    private final String nameItem;

    public OrderItem3() {
        this.nameItem = "3. Create new Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
