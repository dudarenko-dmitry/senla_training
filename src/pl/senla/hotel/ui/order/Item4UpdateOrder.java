package pl.senla.hotel.ui.order;

import pl.senla.hotel.ui.MenuItem;

public class Item4UpdateOrder implements MenuItem {

    private final String nameItem;

    public Item4UpdateOrder() {
        this.nameItem = "4. Update Order.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
