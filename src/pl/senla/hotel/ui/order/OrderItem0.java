package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class OrderItem0 implements MenuItem {

    private final String nameItem;

    public OrderItem0() {
        this.nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
