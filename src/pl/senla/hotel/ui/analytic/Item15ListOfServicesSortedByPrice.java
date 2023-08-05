package pl.senla.hotel.ui.analytic;

import pl.senla.hotel.ui.MenuItem;

public class Item15ListOfServicesSortedByPrice implements MenuItem {

    private final String nameItem;

    public Item15ListOfServicesSortedByPrice() {
        this.nameItem = "15. View the list of guest services and their price sort by price.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
