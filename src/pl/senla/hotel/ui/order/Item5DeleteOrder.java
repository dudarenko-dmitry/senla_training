package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class Item5DeleteOrder implements MenuItem {

    private final String nameItem;

    public Item5DeleteOrder() {
        this.nameItem = "5. Delete Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
