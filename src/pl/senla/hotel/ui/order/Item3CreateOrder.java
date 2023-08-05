package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class Item3CreateOrder implements MenuItem {

    private final String nameItem;

    public Item3CreateOrder() {
        this.nameItem = "3. Create new Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
